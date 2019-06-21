package com.finalwork.qunawan.controller;

import com.finalwork.qunawan.globle.Constants;
import com.finalwork.qunawan.pojo.User;
import com.finalwork.qunawan.service.UserService;
import com.finalwork.qunawan.utils.RandomCode;
import com.finalwork.qunawan.utils.RandomCode;
import com.finalwork.qunawan.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping("logout")
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    @RequestMapping("/login")
    public String login(User user, String code, HttpSession session, RedirectAttributes attr) {
        String username = user.getPhone();
        String password = user.getPassword();
        user.setPassword(Utils.toMD5(password));
        System.out.println(user.getPassword());
        System.out.println(username + " -- " + password);

        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
        random=random.toLowerCase();
        System.out.println(random+":"+code);
        if (random == null) {
            System.out.println("77777777777");
            return "redirect:/";

        }
        if(!random.equals(code)){
            attr.addFlashAttribute(Constants.ERROR, "验证码错误！");
            return  "redirect:/";
        }
        if (userService.login(user)){
            User user1=userService.findUserById(userService.getUserId(username));
            session.setAttribute(Constants.USER_KEY,user1);
            session.setAttribute("userId",userService.getUserId(username));
            System.out.println("8888888888888");
            return "redirect:/index";
            //return "redirect:/pages/index";
        }
        System.out.println("9999999999999");
        attr.addFlashAttribute(Constants.ERROR, "用户名或密码错误！");
        return  "redirect:/";

    }

    @RequestMapping("/register")
    public String Regist(String phone, HttpSession session, RedirectAttributes attr){

        if(userService.getUser(phone)==1){
            attr.addFlashAttribute(Constants.ERROR, "账号存在不能注册！");
            return  "redirect:/";
        }
        else {
            userService.regist(phone);
            attr.addFlashAttribute(Constants.ERROR, "注册成功！");
            return  "redirect:/";
        }
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
