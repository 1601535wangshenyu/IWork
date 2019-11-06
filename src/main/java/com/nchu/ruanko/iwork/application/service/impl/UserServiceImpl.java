package com.nchu.ruanko.iwork.application.service.impl;

import com.nchu.ruanko.iwork.application.service.UserService;
import com.nchu.ruanko.iwork.dao.UserDao;
import com.nchu.ruanko.iwork.domain.entity.User;
import com.nchu.ruanko.iwork.utils.string.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByKeyAndPassword(String key, String password) {
        return userDao.getUserByWorkIdAndPassword(key,StringUtils.encodeMd5(password));
    }


    /**
     * 判断该邮箱是否已被注册
     *
     * @param mail 邮箱
     * @return 是否已被注册
     */
    @Override
    public boolean checkUniqueUserWithMail(String mail) {
        return userDao.countUserByMail(mail) == 0;
    }

    /**
     * 注册用户逻辑
     * @param user
     */
    @Override
    public void RegUser(User user) {
        userDao.updateUserByWorkId(user);
    }

    /**
     * 判断该手机号是否已被注册
     *
     * @param phone 手机号
     * @return 是否已被注册
     */
    @Override
    public boolean checkUniqueUserWithPhone(String phone) {
        return userDao.countUserByPhone(phone) == 0;
    }
}
