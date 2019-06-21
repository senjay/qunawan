package com.finalwork.qunawan.service.impl;

import com.finalwork.qunawan.dao.*;
import com.finalwork.qunawan.globle.Constants;
import com.finalwork.qunawan.pojo.*;
import com.finalwork.qunawan.service.OrdersService;
import com.finalwork.qunawan.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrdersServiceImpl
 * Description TODO
 * @Author 俞立栋
 * Date 2019/6/19 20:32
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    private OrdercontactMapper orderContactMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PriceMapper priceMapper;

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private SequenceMapper sequenceMapper;
    @Autowired
    TripMapper tripMapper;
    @Autowired
    TripServiceImpl tripService;
    @Override//获取用户的所有订单信息
    public List<Orders> getOrdersByUid(int uid) {
        return ordersMapper.selectByUid(uid);
    }

    @Override
    public List<Contact> getContactsByOrderId(int orderId) {
        List<Contact> ocs = new ArrayList<Contact>();

        List<Ordercontact> orderContacts = orderContactMapper.getOrderContacts(orderId, Constants.CONTACT_FOR_PLAY);
        if (orderContacts == null || orderContacts.size() < 1)
            return null;

        for (Ordercontact oc : orderContacts) {
            ocs.add(oc.getContactObject());
        }

        return ocs;
    }

    @Override
    public Contact getContactByOrderId(int id) {
        List<Ordercontact> orderContacts = orderContactMapper.getOrderContacts(id, Constants.CONTACT_FOR_URGENT);
        return orderContacts.get(0).getContactObject();
    }

    @Override
    public Orders getOrderById(int oid) {
        Orders orders=ordersMapper.selectByPrimaryKey(oid);
        String username=userMapper.selectByPrimaryKey(orders.getUser()).getName();
        orders.setUsername(username);
        return orders;
    }

    @Override
    public int updateState(int oid) {
        try{
            ordersMapper.updateState(oid);
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
        return 1;
    }

    @Override
    public int getOrdersbyUserandSeqType(int userid, int typeid) {

        return ordersMapper.selectByUserAndType(userid,typeid);
    }

    @Override
    public List<Orders> getOrders(int userId, int sqeid) {
        List<Orders> orders=ordersMapper.selectOrdersByCondition(userId,sqeid);
        for (int i = 0; i <orders.size() ; i++) {
            Orders order=orders.get(i);

            order.setTripObject(tripService.getTripById(order.getTrip()));
            order.setUserObject(userMapper.selectByPrimaryKey(order.getUser()));
            order.setSequence(sequenceMapper.selectByPrimaryKey(order.getState()));
        }
        return  orders;
    }

    /**
     * 通过出行日期和人数以及trip获取价格
     */

//    @Override
//    public Float getTripPrice(Date date, int num, Trip trip) {
//        Price price = priceMapper.getOneDayPrice(trip.getId(), date);
//        Float p = price.getPrice();
//        return p * num;
//    }
//
//    @Override
//    public void putOrder(Orders order, Contact em_contact, List<Contact> clist) {
//
//    }
//
//
//    @Override
//    public Contact packContact(String id, String name, String phone, User user) {
//        return packContact(id, name, phone, null, user);
//    }
//
//    @Override
//    public Contact packContact(String id, String name, String phone, String cardno, User user) {
//        Contact em_contact = null;
//        if (id !=null && "-1".equals(id)) {
//            if(cardno != null)
//                em_contact = new Contact(user, name, phone, cardno);
//            else
//                em_contact = new Contact(user, name, phone);
//        } else {
//            em_contact = contactMapper.getContactById(Integer.parseInt(id));
//        }
//        return em_contact;
//    }
//
//    @Override
//    public Orders packOrder(int num, java.util.Date time, float total_price,
//                            String place, Trip trip, User user) {
//        // 封装订单信息
//        Orders order = new Orders();
//
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String timestr = df.format(new Date(System.currentTimeMillis()));
//        order.setCreate_time(timestr);
//
//        order.setGo_point(place);
//        order.setGo_time(trip.getSchedule().getTraffic().getGo_time());
//        order.setNum(num);
//        order.setStart_time(new java.sql.Date(time.getTime()));
//        order.setTrip(trip);
//        order.setUser(user);
//        order.setTotal_price(total_price);
//
//        // 订单状态生成
//        Sequence sq = sequenceMapper.getSeqByKeyAndType(Constants.WAIT_PAY_STATE, Constants.ORDER_TYPE);
//        order.setState(sq);
//
//        // 订单编号生成
//        String no = Utils.createName();
//        order.setOrderNo(no);
//        return order;
//    }
}
