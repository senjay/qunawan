package com.finalwork.qunawan.service;

import com.finalwork.qunawan.pojo.Contact;

import java.util.List;

public interface ContactService {
    //獲取當前用戶的所有聯繫人
    List<Contact> getContactByUser(int uid);
    //新增聯繫人
    int addContact(Contact contact);
    //修改聯繫人
    int updateContact(Contact contact);
    //刪除聯繫人
    int delContact(int cid);
}
