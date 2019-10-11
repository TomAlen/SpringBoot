package com.tomalen.springlanuch.Controller;

import com.tomalen.springlanuch.DTO.CommentCreateDTO;
import com.tomalen.springlanuch.DTO.CommentDTO;
import com.tomalen.springlanuch.DTO.ResultDTO;
import com.tomalen.springlanuch.Enum.CommentEnumType;
import com.tomalen.springlanuch.Servrice.CommentService;
import com.tomalen.springlanuch.exception.TomalenErrorCode;
import com.tomalen.springlanuch.exception.TomalenException;
import com.tomalen.springlanuch.pojo.Comment;
import com.tomalen.springlanuch.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author:钟炜宏
 * Date:2019/8/31
 */
@Controller
public class CommentController {


    @Autowired
    private CommentService commentService;

    //添加评论进数据库
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseBody
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        //返回异常码和异常信息
        if (user == null) {
            return ResultDTO.errorOf(2002, "用户未登录，是否登录登录？");
        }
        //判断传入的评论内容是否为空
        if (commentCreateDTO.getContent().isEmpty()) {
            throw new TomalenException(TomalenErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        //创建时间
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        comment.setCommentor(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment, user);
        return ResultDTO.okOf();
    }


    //获取二级评论列表
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO<List<CommentDTO>> getComment(@PathVariable(name = "id") Integer id) {
        List<CommentDTO> commentDTOS = commentService.listCommentOrQuestionById(id, CommentEnumType.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }


}
