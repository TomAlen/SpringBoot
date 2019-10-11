package com.tomalen.springlanuch.advice;

import com.alibaba.fastjson.JSON;
import com.tomalen.springlanuch.DTO.ResultDTO;
import com.tomalen.springlanuch.exception.TomalenErrorCode;
import com.tomalen.springlanuch.exception.TomalenException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:钟炜宏
 * Date:2019/8/30
 */
@ControllerAdvice
public class TomalenExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(Throwable e,
                                           Model model,
                                           HttpServletRequest request,
                                           HttpServletResponse response) {
        String contentType = request.getContentType();
        //判断请求头是否为json格式
        if("application/json".equals(contentType)) {
            //返回json
            ResultDTO resultDTO = new ResultDTO();
            //判断异常是否属于自定义的异常
            if(e instanceof TomalenException) {
                resultDTO = resultDTO.errorOf(TomalenErrorCode.QUESTION_NOT_FOUND);
            }else{
                resultDTO = resultDTO.errorOf(TomalenErrorCode.SYS_ERROR);
            }
            try {
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.setStatus(200);
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return null;
        }else{
            if(e instanceof TomalenException) {
                model.addAttribute("message",e.getMessage());//从自己定义的异常中取值
            }else {
                model.addAttribute("message","服务器太热啦！要不稍后试试~");
            }
            return new ModelAndView("error");
        }

    }

}
