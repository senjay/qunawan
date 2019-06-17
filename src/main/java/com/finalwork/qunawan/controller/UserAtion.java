package com.finalwork.qunawan.controller;

import com.finalwork.qunawan.pojo.User;
import com.finalwork.qunawan.service.UserService;
import com.finalwork.qunawan.utils.RandomCode;
import com.finalwork.qunawan.utils.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * author: 钱苏涛
 * created on: 2019/6/17 14:25
 * description:
 */
@Controller
@RequestMapping("/user")
public class UserAtion {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpSession session,String code) {
        System.out.println("2222");
        String username = user.getName();
        String password = user.getPassword();
        System.out.println("122");
        System.out.println(username + " -- " + password);

        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
        System.out.println(random+":"+code);
        if (random == null) {
            return "login";
        }
        if (random.toLowerCase().equals(code)) {
            System.out.println("8888888888888");
        }
        return "login";

//        if(userService.login(user)) {
//            System.out.println("8888888888888");
//            session.setAttribute("userinfo", user);
//        }
//        return "login";
    }

    @RequestMapping("/code")
    public void login(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomCode randomValidateCode = new RandomCode();

            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            System.out.println("获取验证码失败>>>>   "+ e);

        }

    }

}
