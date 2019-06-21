package com.finalwork.qunawan.service.impl;

import com.finalwork.qunawan.dao.SequenceMapper;
import com.finalwork.qunawan.pojo.Sequence;
import com.finalwork.qunawan.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: 钱苏涛
 * created on: 2019/6/18 12:30
 * description:
 */
@Service
public class SequenceServiceImpl implements SequenceService {
    @Autowired
    SequenceMapper sequenceMapper;
    @Override
    public Sequence getSeqByValue(String value) {
        return sequenceMapper.selectByValue(value);
    }

    @Override
    public Sequence getSeqByKeyAndType(String key, String type) {
        return  sequenceMapper.selectByKeyAndType(key,type);
    }
}
