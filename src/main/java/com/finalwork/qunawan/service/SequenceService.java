package com.finalwork.qunawan.service;

import com.finalwork.qunawan.globle.Constants;
import com.finalwork.qunawan.pojo.Sequence;

/**
 * author: 钱苏涛
 * created on: 2019/6/18 12:29
 * description:
 */
public interface SequenceService {
     public  Sequence  getSeqByValue(String value);
     public Sequence getSeqByKeyAndType(String key,String type);
}
