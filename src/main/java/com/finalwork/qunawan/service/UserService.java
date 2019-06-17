package com.finalwork.qunawan.service;

import com.finalwork.qunawan.pojo.User;

/**
 * author: 钱苏涛
 * created on: 2019/6/17 14:26
 * description:
 */
public interface UserService {
    public User findUserById(int id);
    public boolean login(User user);
}
