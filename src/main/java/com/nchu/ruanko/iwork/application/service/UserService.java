package com.nchu.ruanko.iwork.application.service;

import com.nchu.ruanko.iwork.domain.entity.User;

public interface UserService {
    /**
     * 获取 User，依据是会员号/邮箱/手机号与密码
     *
     * @param key 会员号/邮箱/手机号
     * @param password 密码
     * @return User
     */
    User getUserByKeyAndPassword(String key, String password);
}
