package com.nchu.ruanko.iwork.application.service.impl;

import com.nchu.ruanko.iwork.application.service.UserService;
import com.nchu.ruanko.iwork.dao.UserDao;
import com.nchu.ruanko.iwork.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByKeyAndPassword(String key, String password) {
        return userDao.getUserByWorkIdAndPassword(key,password);
    }
}
