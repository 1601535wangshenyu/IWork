package com.nchu.ruanko.iwork.web.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.nchu.ruanko.iwork.application.service.UserService;
import com.nchu.ruanko.iwork.domain.constant.CrossConstant;
import com.nchu.ruanko.iwork.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;

    private final AtomicLong counter = new AtomicLong();


    @CrossOrigin(origins = "http://"+ CrossConstant.ALLOW_IP+":8081")
    @PostMapping(value = "/user/password/login/operation")
    @ResponseBody
    public String userLoginWithPasswordOperation(@RequestBody Map map, HttpServletRequest request) {
        String key =(String) map.get("key");
        String password =(String) map.get("password");
        String vcode =(String) map.get("vcode");

        System.out.println(key);
        System.out.println(password);
        JSONObject json = new JSONObject();
        HttpSession session = request.getSession();
        User user;
        String code = (String) session.getAttribute("graphVcode");
        if (!code.equals(vcode)) {
            json.put("flag", false);
            json.put("reason", "验证码错误！");
            session.removeAttribute("graphVcode");
        } else {
            user = userService.getUserByKeyAndPassword(key, password);
            if (user == null) {
                json.put("flag", false);
                json.put("reason", "账号或密码错误！");
                session.removeAttribute("graphVcode");
            } else {
                json.put("flag", true);
                session.removeAttribute("graphVcode");
                session.setAttribute("user", user);
            }
        }
        return json.toString();
    }




}
