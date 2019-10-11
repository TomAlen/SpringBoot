package com.tomalen.springlanuch.DTO;

import com.tomalen.springlanuch.exception.TomalenErrorCode;
import lombok.Data;

/**
 * Author:钟炜宏
 * Date:2019/8/31
 * 异常处理，返回异常码和异常信息
 */
@Data
public class ResultDTO<T> {

    private Integer code;

    private String message;

    private T data;
    //返回错误的状态码
    public static ResultDTO errorOf(Integer code,String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return  resultDTO;
    }

    //返回值为自定义的错误状态码
    public static ResultDTO errorOf(TomalenErrorCode code){
        ResultDTO resultDTO = ResultDTO.errorOf(code.getCode(), code.getMessage());
        return  resultDTO;
    }

    //返回成功的状态码
    public static ResultDTO okOf() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功！");
        return resultDTO;
    }

    //返回的泛型
    public static <T> ResultDTO okOf(T t) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功！");
        //把传入的数据封装
        resultDTO.setData(t);
        return resultDTO;
    }

}
