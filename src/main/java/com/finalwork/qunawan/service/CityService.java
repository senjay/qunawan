package com.finalwork.qunawan.service;

import com.finalwork.qunawan.pojo.City;

import java.util.List;

public interface CityService {
    public List<City> getAllCity(Integer type);
    public City getCity(Integer id);
}
