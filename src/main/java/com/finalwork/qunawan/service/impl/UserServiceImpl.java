package com.finalwork.qunawan.service.impl;

import com.finalwork.qunawan.dao.UserMapper;
import com.finalwork.qunawan.pojo.User;
import com.finalwork.qunawan.service.UserService;
import com.finalwork.qunawan.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: 钱苏涛
 * created on: 2019/6/17 14:27
 * description:
 */
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(int id) {
        // TODO Auto-generated method stub
        return userMapper.selectByPrimaryKey(id);
    }
    @Override
    public boolean login(User user) {
        // TODO Auto-generated method stub
        return userMapper.checkUser(user) != null ? true : false;
    }

    @Override
    public int getUser(String uid) {
        return userMapper.getUser(uid);
    }

    @Override
    public void regist(String name) {
        User user=new User();
        user.setPhone(name);
        user.setPassword(Utils.toMD5("123456"));
        userMapper.insert(user);
    }

    @Override
    public void upDate(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int getUserId(String phone) {
        return userMapper.getUserId(phone);
    }

    @Override
    public void updatePassword(int uid, String pwd) {
        userMapper.updatePassword(uid,pwd);
    }

}
