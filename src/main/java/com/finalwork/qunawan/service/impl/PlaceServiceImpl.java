package com.finalwork.qunawan.service.impl;

import com.finalwork.qunawan.dao.PlaceMapper;
import com.finalwork.qunawan.pojo.Place;
import com.finalwork.qunawan.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author: 钱苏涛
 * created on: 2019/6/18 15:39
 * description:
 */
@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    PlaceMapper placeMapper;
    @Override
    public List<String> getPlacenameByType(int type) {
        List<String> list=new ArrayList<String>();
        List<Place> places=placeMapper.selectByType(type);
        for (int i = 0; i < places.size(); i++) {
            list.add(places.get(i).getName());
        }
        return list;
    }
}
