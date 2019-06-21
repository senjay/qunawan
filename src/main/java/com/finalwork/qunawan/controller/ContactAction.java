package com.finalwork.qunawan.controller;

import com.finalwork.qunawan.pojo.Contact;
import com.finalwork.qunawan.service.ContactService;
import com.finalwork.qunawan.utils.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ContactAction
 * Description TODO
 * @Author 俞立栋
 * Date 2019/6/20 10:26
 */
@Controller
@RequestMapping("/contact")
public class ContactAction {
    @Autowired
    ContactService contactService;
    @RequestMapping("/show")
    @ResponseBody
    public Map<String, Object> showContact(@RequestParam(value = "page", defaultValue = "1") Integer pn,
                                           HttpSession session, HttpServletRequest request){
        System.out.println("----------page-----------");
//        int pn=Integer.parseInt(request.getParameter("page"));
        int uid=(int)session.getAttribute("userId");
        PageHelper.startPage(pn, 5); //紧接着的查询会被分页
        List<Contact> contacts=contactService.getContactByUser(uid);
        for(int i=0;i<contacts.size();i++){
            Date date=contacts.get(i).getBirthday();
            if(date!=null) {
                String s = DateFormat.getDateInstance().format(date);
                contacts.get(i).setBirthdayst(s);
            }else {
                contacts.get(i).setBirthdayst("");
            }
        }
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数5
        PageInfo<Contact> page = new PageInfo<Contact>(contacts);
        //使用map集合存放对象信息，返回数据
        Map<String, Object> results = new HashMap<String, Object>();
        results.put("pageInfo", page);
        return results;
    }

    public void packYld(Contact contact,HttpServletRequest request,HttpSession session){
        String year=request.getParameter("c_sel_year");
        String month=request.getParameter("c_sel_month");
        String date=request.getParameter("c_sel_day");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(year+"-"+month+"-"+date, pos);
        contact.setBirthday(strtodate);
        contact.setUser((int)session.getAttribute("userId"));
        System.out.println(contact.toString());
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addContact(Contact contact,HttpServletRequest request,HttpSession session){
        packYld(contact,request,session);
        int i = contactService.addContact(contact);
        if(i==1)
            return "添加成功";
        else
            return  "添加失敗";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateContact(Contact contact,HttpServletRequest request,HttpSession session){
        packYld(contact,request,session);
        int i = contactService.updateContact(contact);
        return "修改成功";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delContact(@RequestParam(value = "c_id") Integer cid){
        contactService.delContact(cid);
        return "刪除成功";
    }

}
