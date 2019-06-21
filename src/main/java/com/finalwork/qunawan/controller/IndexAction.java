package com.finalwork.qunawan.controller;

import com.finalwork.qunawan.globle.Constants;
import com.finalwork.qunawan.globle.Globle;
import com.finalwork.qunawan.pojo.Trip;
import com.finalwork.qunawan.pojo.User;
import com.finalwork.qunawan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: 钱苏涛
 * created on: 2019/6/18 11:27
 * description:
 */
@Controller

public class IndexAction {
    @Autowired
    SequenceService sequenceService;
    @Autowired
    TripService tripService;
    @Autowired
    PlaceService placeService;
    @Autowired
    ThemeService themeService;
    @RequestMapping("/index")
    public String getIndexinfo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        // 显示的行程列

        Map<String, List<Trip>> tripMap = new HashMap<>();
        // 页面显示的景点列表
        Map<String, List<String>> placeMap = new HashMap<>();
        // 页面显示的主题列表
        Map<String, List<String>> themeMap = new HashMap<>();
        String[] tripTypes = Constants.TRIP_TYPE;
        // 使用'自驾游'、'国内游'和'出境游'为键，存放各自要显示的列表集合
        for (int i = 0; i < 3; i++) {
            int typeId = sequenceService.getSeqByValue(tripTypes[i]).getId();
            List<Trip> items = tripService.getTripByType(typeId);
            tripMap.put(tripTypes[i], items);
            for (Trip trip : items){
                tripService.initTripPicture(trip.getPic_list(),
                        ResourceUtils.getURL("classpath:").getPath());
            }

            placeMap.put(tripTypes[i], placeService.getPlacenameByType(typeId));
            themeMap.put(tripTypes[i], themeService.getThemenameByType(typeId));

        }
        request.setAttribute(Constants.INDEX_TRIP_MAP, tripMap);
        request.setAttribute(Constants.INDEX_PLACE_MAP, placeMap);
        request.setAttribute(Constants.INDEX_THEME_MAP, themeMap);

        // 如果当前用户已登录，则记录访问首页的时间和次数
        if (request.getSession().getAttribute(Constants.USER_KEY) != null) {
            // 获取用户id
            Integer uid = ((User) request.getSession().getAttribute(Constants.USER_KEY)).getId();
            // 添加首页访问记录
            Globle.addAccessRecord(uid, Constants.INDEX_PAGE);
        }


        return "pages/index";
    }
}
