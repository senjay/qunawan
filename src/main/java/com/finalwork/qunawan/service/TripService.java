package com.finalwork.qunawan.service;

import com.finalwork.qunawan.form.SearchForm;
import com.finalwork.qunawan.pojo.Trip;
import com.finalwork.qunawan.pojo.Trippicture;

import java.util.List;
import java.util.Set;

/**
 * author: 钱苏涛
 * created on: 2019/6/18 14:09
 * description:
 */
public interface TripService {
    public List<Trip> getTripByType(int type);
    public void initTripPicture(Set<Trippicture> pictures, String basePath);
    public Trip getTripById(int id);
    public List<Trip> getSearchTripsByVo(SearchForm vo);
}
