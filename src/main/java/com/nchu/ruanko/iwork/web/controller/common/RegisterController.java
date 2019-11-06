package com.nchu.ruanko.iwork.web.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.exceptions.ClientException;
import com.nchu.ruanko.iwork.application.service.MailService;
import com.nchu.ruanko.iwork.application.service.UserService;
import com.nchu.ruanko.iwork.domain.entity.User;
import com.nchu.ruanko.iwork.utils.http.HttpUtils;
import com.nchu.ruanko.iwork.utils.shortmessage.ShortMessageErrorsEnum;
import com.nchu.ruanko.iwork.utils.shortmessage.ShortMessageUtils;
import com.nchu.ruanko.iwork.utils.string.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * “注册”功能控制器
 *
 * @author Wang Shenyu
 */
@Api(tags = "common.RegisterController", description = "“注册”功能控制器")
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    /**
     * 手机短信模板
     */
    private static final String MESSAGE_TEMPLATE = "SMS_174020806";


    /**
     * 收集前端传来的会员/用户“注册”数据，完成校验，数据暂存在 Session 中的 tempUser，然后发送“激活账号”邮件
     *
     * @return JSON
     */
    @ApiOperation(value = "sendMailVerificationCodeOperation", notes = "发送邮箱验证码")
    @PostMapping(value = "/mail/vcode/register")
    @ResponseBody
    public String sendMailVerificationCodeOperation(@RequestBody Map map, HttpServletRequest request) {

        String mail= (String)map.get("mail");
        HttpSession session = request.getSession();
        String vcode = StringUtils.createVerificationCode(5);
        JSONObject json = new JSONObject();
        if (!userService.checkUniqueUserWithMail(mail)) {
            json.put("result", false);
            json.put("reason", "您的邮箱已被注册！");
        } else {


            // TODO 此处有 BUG ，因为 Session 的缘故一旦切换浏览器就无法激活，500
            User user = new User();
            user.setUserUid(StringUtils.createUUID());
            user.setMail(mail);
            session.setAttribute("vcode",vcode);
            session.setAttribute("tempUser", user);


            HttpUtils.sessionAttributeInvalid(session, "tempUser", 5);
            HttpUtils.sessionAttributeInvalid(session, "vcode", 5);
            Map<String, Object> val = new HashMap<>(5);
            val.put("mail", mail);
            val.put("vcode",vcode);

            try {
                mailService.sendThymeleafTemplateMail(mail, "【iwork】账户激活", "/mail/register-activate", val);
            } catch (Exception e) {
                e.printStackTrace();
                json.put("result", false);
                json.put("reason", "邮件发送失败！system");
                return json.toString();
            }
            json.put("result", true);
        }
        return json.toString();
    }

    /**
     * 邮件注册操作
     *
     *
     *
     * @return 页面
     */
    @ApiOperation(value = "userRegisterWitMailOperation", notes = "邮件注册操作")
    @GetMapping(value = "/user/register/mail/operation")
    @ResponseBody
    public String userRegisterWitMailOperation(@RequestBody Map map,  HttpServletRequest request) {

        String password= (String)map.get("password");
        String mail= (String)map.get("phone");
        String vcode= (String)map.get("vcode");
        String workId = (String)map.get("workId");
        JSONObject json = new JSONObject();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("tempUser");
        String code = (String) session.getAttribute("vcode");
        if (user == null || vcode == null) {
            json.put("result", false);
            json.put("reason", "验证码已失效，请重新获取！");
        } else {
            if (!user.getMail().equals(mail) || !code.equals(vcode)) {
                json.put("result", false);
                json.put("reason", "验证码错误！");
            } else {
                user.setPassword(password);
                user.setWorkId(workId);
                userService.RegUser(user);
                json.put("result", true);
                session.removeAttribute("tempUser");
                session.removeAttribute("vcode");
            }
        }
        return json.toString();
    }

    /**
     * 发送注册时所用的手机短信验证码
     *
     * @param map
     * @param request HTTP 请求
     * @return JSON
     */
    @ApiOperation(value = "sendMessageVerificationCodeOperation", notes = "发送注册时所用的手机验证码短信")
    @PostMapping(value = "/message/vcode/register")
    @ResponseBody
    public String sendMessageVerificationCodeOperation(@RequestBody Map map,HttpServletRequest request) {
        String phone = (String)map.get("phone");
        JSONObject json = new JSONObject();
        HttpSession session = request.getSession();
        String vcode = StringUtils.createVerificationCode(5);
        if (!userService.checkUniqueUserWithPhone(phone)) {
            json.put("result", false);
            json.put("reason", "您的手机号已被注册！");
        } else {
            try {
                String responseData = ShortMessageUtils.sendVerificationCodeMessage(MESSAGE_TEMPLATE, phone, vcode);
                if (ShortMessageErrorsEnum.OK.getCode().equals(ShortMessageUtils.getErrorCode(responseData))) {
                    json.put("result", true);
                    // 手机号隐藏中间四位
                    json.put("phone", StringUtils.desensitizePhoneNumber(phone));
                    User user = new User();
                    user.setUserUid(StringUtils.createUUID());
                    user.setPhone(phone);
                    session.setAttribute("tempUser", user);
                    session.setAttribute("messageVcode", vcode);

                    HttpUtils.sessionAttributeInvalid(session, "tempUser", 5);
                    HttpUtils.sessionAttributeInvalid(session, "messageVcode", 5);
                } else {
                    json.put("result", false);
                    json.put("reason", ShortMessageUtils.getErrorDescription(responseData));
                }
            } catch (ClientException e) {
                e.printStackTrace();
                json.put("result", false);
                json.put("reason", "短信发送失败！system");
                return json.toString();
            }
        }
        return json.toString();
    }


    /**
     * 手机短信验证码注册操作
     *
     * @param request HTTP 请求
     * @return JSON
     */
    @ApiOperation(value = "userRegisterWithPhoneOperation", notes = "手机验证注册")
    @PostMapping(value = "/user/register/phone/operation")
    @ResponseBody
    public String userRegisterWithPhoneOperation(@RequestBody Map map,  HttpServletRequest request) {
        String password= (String)map.get("password");
        String phone= (String)map.get("phone");
        String vcode= (String)map.get("vcode");
        String workId = (String)map.get("workId");
        JSONObject json = new JSONObject();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("tempUser");
        String code = (String) session.getAttribute("messageVcode");
        if (user == null || vcode == null) {
            json.put("flag", false);
            json.put("reason", "验证码已失效，请重新获取！");
        } else {
            if (!user.getPhone().equals(phone) || !code.equals(vcode)) {
                json.put("flag", false);
                json.put("reason", "验证码错误！");
            } else {
                user.setPassword(password);
                user.setWorkId(workId);
                userService.RegUser(user);
                json.put("flag", true);
                session.removeAttribute("tempUser");
                session.removeAttribute("messageVcode");
            }
        }
        return json.toString();
    }

}