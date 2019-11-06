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
    /**
     * 判断邮箱是否被使用过（被账号绑定过）
     *
     * @param mail 邮箱
     * @return 当前邮箱是否已经被使用过，true 未被使用过；false 被使用过
     */
    boolean checkUniqueUserWithMail(String mail);


    /**
     * 注册用户
     * @param user
     */
    void RegUser(User user);
    /**
     * 判断手机号码是否被使用过（被账号绑定过）
     *
     * @param phone 手机号码
     * @return 当前手机号码是否已经被使用，true 未被使用；false 被使用过
     */
    boolean checkUniqueUserWithPhone(String phone);
}
