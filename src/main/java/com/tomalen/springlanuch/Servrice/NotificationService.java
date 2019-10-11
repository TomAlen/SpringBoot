package com.tomalen.springlanuch.Servrice;

import com.tomalen.springlanuch.DTO.NotificationDTO;
import com.tomalen.springlanuch.DTO.paginitionDTO;
import com.tomalen.springlanuch.Enum.NotificationStatusEnum;
import com.tomalen.springlanuch.Enum.NotificationTypeEnum;
import com.tomalen.springlanuch.Mapper.NotificationMapper;
import com.tomalen.springlanuch.exception.TomalenErrorCode;
import com.tomalen.springlanuch.exception.TomalenException;
import com.tomalen.springlanuch.pojo.Notification;
import com.tomalen.springlanuch.pojo.NotificationExample;
import com.tomalen.springlanuch.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alen zhong
 * @date 19-9-8
 */
@Service
public class NotificationService {

    @Autowired
    private NotificationMapper notificationMapper;

    public paginitionDTO list(Integer id, Integer page, Integer size) {
        paginitionDTO<NotificationDTO> paginitionDTO = new paginitionDTO();
        //查询总数
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria()
                .andReceiverEqualTo(id);
        Integer total = (int) notificationMapper.countByExample(notificationExample);

        paginitionDTO.setPaginition(total, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginitionDTO.getTotalPage()) {
            page = paginitionDTO.getTotalPage();
        }
        //计算出偏移量
        //5*(i-1)
        long offset;
        offset = size * (page - 1);
        if (offset <= 0) {
            offset = 1;
        }

        NotificationExample example = new NotificationExample();
        example.createCriteria()
                .andReceiverEqualTo(id);
        //设置分页的大小，偏移量和每一页的大小
        example.setOffset(offset);
        example.setLimit(size);
        //将创建的时间改为倒叙排序，这样就可以看到最新评论的在最开始
        example.setOrderByClause("gmt_create desc");
        List<Notification> notifications = notificationMapper.selectByExample(example);



        //如果通知为空，就直接返回分页信息
        if (notifications.size() == 0) {
            return paginitionDTO;
        }

        //初始化一个集合
        List<NotificationDTO> notificationDTOS = new ArrayList<>(0);

        //将查出的通知集合依次转换DTO对象
        for (Notification notification : notifications) {
            NotificationDTO notificationDTO = new NotificationDTO();
            //复制属性值
            BeanUtils.copyProperties(notification,notificationDTO);
            notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getNotifiedType()));
            notificationDTO.setStatus(notification.getNotifiedStatus());
            notificationDTO.setType(notification.getNotifiedType());
            notificationDTOS.add(notificationDTO);
        }

        //把questionDTOList数据插入进去
        paginitionDTO.setData(notificationDTOS);
        return paginitionDTO;
    }

    //获取未读的回复数
    public Integer unreadCount(Integer id) {
        NotificationExample notificationExample = new NotificationExample();
        notificationExample
                .createCriteria()
                .andReceiverEqualTo(id)
                .andNotifiedStatusEqualTo(NotificationStatusEnum.UNREAD.getStatus());
        Integer count = (int)notificationMapper.countByExample(notificationExample);
        return count;
    }

    //表示已读
    public NotificationDTO readNotified(Integer id, User user) {
        Notification notification = notificationMapper.selectByPrimaryKey(id);

        //判断通知是否为空
        if(notification == null){
            throw new TomalenException(TomalenErrorCode.NOTIFICATION_NOT_FOUND);
        }

        //判断当前通知的用户是否为登录时的用户
        if(!notification.getReceiver().equals(user.getId())) {
            throw new TomalenException(TomalenErrorCode.READ_NOTIFICATION_FAIL);
        }

        //更新为已读状态
        notification.setNotifiedStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByPrimaryKey(notification);

        NotificationDTO notificationDTO = new NotificationDTO();
        //复制属性值
        BeanUtils.copyProperties(notification,notificationDTO);
        //将未读或者已读的状态添加
        notificationDTO.setStatus(notification.getNotifiedStatus());
        //将评论的类型添加，评论回复或者评论问题
        notificationDTO.setType(notification.getNotifiedType());
        notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getNotifiedType()));
        return notificationDTO;
    }
}
