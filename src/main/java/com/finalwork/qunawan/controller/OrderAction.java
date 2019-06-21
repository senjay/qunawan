package com.finalwork.qunawan.controller;

import com.finalwork.qunawan.pojo.OrderDetailForm;
import com.finalwork.qunawan.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName OrderAction
 * Description TODO
 * @Author 俞立栋
 * Date 2019/6/20 16:50
 */
@Controller
public class OrderAction {

    @Autowired
    OrdersService ordersService;
    public OrderDetailForm pack(String id){
        Integer order_id = Integer.parseInt(id);
        OrderDetailForm orderDetailForm = new OrderDetailForm();
        orderDetailForm.setContact_many(ordersService.getContactsByOrderId(order_id));
        orderDetailForm.setContact_one(ordersService.getContactByOrderId(order_id));
        orderDetailForm.setOrder(ordersService.getOrderById(order_id));
        return orderDetailForm;
    }
    @RequestMapping("/myorder")
    public String goOrderD(HttpServletRequest request){
        request.getParameter("order_id");
        String id = request.getParameter("order_id");
        if (id == null)
            return "pages/personal_myOrder";
        OrderDetailForm orderDetailForm=pack(id);
        request.setAttribute("orderDetailForm", orderDetailForm);
        return "pages/order_detail";
    }

    @RequestMapping("/go_pay")
    public String goPay(HttpServletRequest request){
        String id = request.getParameter("id");
        if (id == null)
            return "pages/personal/personal_myOrder";
        OrderDetailForm orderDetailForm=pack(id);
        request.getSession().setAttribute("vo", orderDetailForm);
        return "pages/order_pay";
    }

    @RequestMapping("/pay_success")
    public String goPaySuccess(HttpServletRequest request){
        int oid=Integer.parseInt(request.getParameter("id"));
        int i=ordersService.updateState(oid);
        if(i==1)
            return "pages/order_success";
        else
            return "pages/order_success";
    }
}
