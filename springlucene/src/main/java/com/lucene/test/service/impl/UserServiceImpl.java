package com.lucene.test.service.impl;

import com.lucene.test.dao.user.UserMapper;
import com.lucene.test.entity.user.User;
import com.lucene.test.entity.user.UserExample;
import com.lucene.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang_htao on 2019/12/4.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUsers() {
        UserExample userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }
}
