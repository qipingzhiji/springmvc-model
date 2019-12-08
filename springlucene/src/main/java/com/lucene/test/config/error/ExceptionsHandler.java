package com.lucene.test.config.error;

import com.lucene.test.config.error.exception.CustomGenericException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhang_htao on 2019/12/5.
 */
@ControllerAdvice(basePackages = "com.lucene.test.controller")
public class ExceptionsHandler {

    //@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR,reason = "服务器处理错误")
    @ExceptionHandler(value = CustomGenericException.class)
    public ModelAndView customGenericExceptionHnadler(CustomGenericException exception, HttpServletRequest request){
        String name = request.getParameter("name");
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errCode",exception.getErrorCode());
        modelAndView.addObject("errMsg",exception.getErrmsg() + "输入的用户名是：" + name);
        return modelAndView;
    }
}
