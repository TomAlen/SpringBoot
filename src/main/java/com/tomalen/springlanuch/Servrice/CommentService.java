package com.tomalen.springlanuch.Servrice;

import com.tomalen.springlanuch.DTO.CommentDTO;
import com.tomalen.springlanuch.Enum.CommentEnumType;
import com.tomalen.springlanuch.Enum.NotificationStatusEnum;
import com.tomalen.springlanuch.Enum.NotificationTypeEnum;
import com.tomalen.springlanuch.Mapper.*;
import com.tomalen.springlanuch.exception.TomalenErrorCode;
import com.tomalen.springlanuch.exception.TomalenException;
import com.tomalen.springlanuch.pojo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author:钟炜宏
 * Date:2019/8/31
 */
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentExtMapper commentExtMapper;

    @Autowired
    private NotificationMapper notificationMapper;

    //添加评论 添加事务
    @Transactional
    public void insert(Comment comment,User commentator) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            //排除自定义的异常
            throw new TomalenException(TomalenErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getType() == null && !CommentEnumType.isExist(comment.getType())) {
            throw new TomalenException(TomalenErrorCode.TYPE_PARAM_WRONG);
        }
        //回复或者提问
        if (comment.getType() == CommentEnumType.COMMENT.getType()) {
            //回复
            Comment Dbcomment = commentMapper.selectByPrimaryKey(comment.getParentId());
            //为空，抛异常
            /*if(Dbcomment == null) {
                throw new TomalenException(TomalenErrorCode.COMMENT_NOT_FOUND);
            }*/
            commentMapper.insert(comment);
            //增加评论数
            Comment parentComment = new Comment();
            //先找到评论的父评论，在他的基础上进行评论数的更改
            parentComment.setId(comment.getParentId());
            parentComment.setCommentCount(1);
            commentExtMapper.incCommentCount(parentComment);

            //查出父类的问题
            Question question = questionMapper.selectByPrimaryKey(Dbcomment.getParentId());

            //回复通知
            Integer commentor = Dbcomment.getCommentor();
            int reply_commentType = NotificationTypeEnum.REPLY_COMMENT.getType();
            CreateCommentNotified(comment, commentor, commentator.getName(), question.getTitle(), reply_commentType,question.getId());
        } else {

            //提问
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new TomalenException(TomalenErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);

            //创建回复问题的通知
            Integer receiver = question.getCreator();
            int reply_questionType = NotificationTypeEnum.REPLY_QUESTION.getType();
            CreateCommentNotified(comment, receiver, commentator.getName(),question.getTitle(),reply_questionType,question.getId());
        }
    }


    //回复通知
    private void CreateCommentNotified(Comment comment, Integer receiver, String notifierName, String outTitle, int NotificationType,Integer outId) {
        //通知业务层
        Notification notification = new Notification();
        notification.setGmtCreate(System.currentTimeMillis());
        //回复评论
        notification.setNotifiedType(NotificationType);
        //通知者
        notification.setNotifier(comment.getCommentor());
        //接收者
        notification.setReceiver(receiver);
        //状态为未读
        notification.setNotifiedStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setOuterId(outId);
        notification.setNotifierName(notifierName);
        notification.setOutTitle(outTitle);
        notificationMapper.insert(notification);
    }

    /**
     * 依据id将评论查出
     *
     * @param id
     * @return
     */
    public List<CommentDTO> listCommentOrQuestionById(Integer id, CommentEnumType type) {
        //根据问题父类id获取回复列表
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria()
                .andParentIdEqualTo(id)
                //判断类型，类型为问题的取出
                .andTypeEqualTo(type.getType());
        //利用时间的降序排序
        commentExample.setOrderByClause("gmt_create desc");
        List<Comment> comments = commentMapper.selectByExample(commentExample);

        //将评论人ID封装成Set集合   java8 新特性 lambda表达式
        //将每一个评论中的评论人封装在Set集合中  获取去重的评论人
        Set<Integer> commentors = comments.stream().map(comment -> comment.getCommentor()).collect(Collectors.toSet());

        if (commentors.size() == 0) {
            return new ArrayList<>();
        }

        //把评论者封装成userId,转换为List集合
        List<Integer> userIds = new ArrayList<>();
        userIds.addAll(commentors);

        //得到user
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andIdIn(userIds);
        List<User> users = userMapper.selectByExample(userExample);
        //把users转换为Map集合，Id为key  user为value
        Map<Integer, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));

        //同理，把从comments同样转换为List集合，与user进行判断是否为同一个人
        List<CommentDTO> commentDTOS = comments.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment, commentDTO);
            //先把在map集合中的user取出，再依次把user传入到CommentDTO数据模型中
            commentDTO.setUser(userMap.get(comment.getCommentor()));
            return commentDTO;
        }).collect(Collectors.toList());
        return commentDTOS;
    }
}
