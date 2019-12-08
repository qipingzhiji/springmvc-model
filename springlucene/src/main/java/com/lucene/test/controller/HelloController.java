package com.lucene.test.controller;

import com.lucene.test.config.error.exception.CustomGenericException;
import com.lucene.test.config.log.annotations.ParamLog;
import com.lucene.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhang_htao on 2019/12/4.
 */
@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "users")
    @ParamLog
    public Object users(){
        return userService.listUsers();
    }

    @GetMapping(value = "err")
    public Object testError(@RequestParam(value = "name") String name) {
        if("admin".equals(name)){
            throw new CustomGenericException("000000","用户信息不正确");
        }
        return "登录成功";
    }
}
