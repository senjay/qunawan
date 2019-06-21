package com.finalwork.qunawan.service.impl;

import com.finalwork.qunawan.dao.CityMapper;
import com.finalwork.qunawan.pojo.City;
import com.finalwork.qunawan.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CityServiceImpl
 * Description TODO
 * @Author 俞立栋
 * Date 2019/6/19 10:13
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;
    @Override
    public List<City> getAllCity(Integer type) {
        return cityMapper.selectByName(type);
    }

    @Override
    public City getCity(Integer id) {
        return cityMapper.selectByPrimaryKey(id);
    }
}
