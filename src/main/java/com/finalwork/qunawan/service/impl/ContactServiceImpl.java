package com.finalwork.qunawan.service.impl;

import com.finalwork.qunawan.dao.ContactMapper;
import com.finalwork.qunawan.pojo.Contact;
import com.finalwork.qunawan.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ContactServiceImpl
 * Description TODO
 * @Author 俞立栋
 * Date 2019/6/20 10:48
 */
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactMapper contactMapper;
    @Override
    public List<Contact> getContactByUser(int uid) {
        return contactMapper.selectByUser(uid);
    }

    @Override
    public int addContact(Contact contact) {
        return contactMapper.insert(contact);
    }

    @Override
    public int updateContact(Contact contact) {
        return contactMapper.updateByPrimaryKey(contact);
    }

    @Override
    public int delContact(int cid) {
        return contactMapper.deleteByPrimaryKey(cid);
    }
}
