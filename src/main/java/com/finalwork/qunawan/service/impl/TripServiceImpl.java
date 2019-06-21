package com.finalwork.qunawan.service.impl;

import com.finalwork.qunawan.dao.*;
import com.finalwork.qunawan.form.SearchForm;
import com.finalwork.qunawan.pojo.*;
import com.finalwork.qunawan.service.TripService;
import com.finalwork.qunawan.utils.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * author: 钱苏涛
 * created on: 2019/6/18 14:09
 * description:
 */
@Service
public class TripServiceImpl implements TripService {
    @Autowired
    TripMapper tripMapper;
    @Autowired
    TrippictureMapper trippictureMapper;
    @Autowired
    PriceMapper priceMapper;
    @Autowired
    CityMapper cityMapper;
    @Autowired
    SequenceMapper sequenceMapper;
    @Autowired
    ScheduleMapper scheduleMapper;
    @Autowired
    DatesMapper datesMapper;
    @Autowired
    PlaceontripMapper placeontripMapper;
    @Autowired
    PositionMapper positionMapper;
    @Autowired
    DetailMapper detailMapper;
    @Autowired
    PlaceMapper placeMapper;
    @Autowired
    ThemeMapper themeMapper;
    @Autowired
    ThemeontripMapper themeontripMapper;
    @Override
    public List<Trip> getTripByType(int type) {
        List<Trip> trips=tripMapper.seletByType(type);
        for (int i = 0; i <trips.size() ; i++) {
            int tid= trips.get(i).getId();
            Set<Trippicture>  pics= trippictureMapper.selectByIdandType(tid,0);//获取主要图片显示 type=0
            trips.get(i).setPic_list(pics);
            trips.get(i).setPrice_list(priceMapper.selectPriceByTripId(tid));

        }
        return trips;
    }

    @Override
    public void initTripPicture(Set<Trippicture> pictures, String basePath) {
        for (Trippicture tp : pictures) {
            String path = basePath + "image_cache\\" + tp.getName();
            if (!new File(path).exists()) {
                Utils.getFile(tp.getData(), path);
            }
        }
    }

    @Override
    public Trip getTripById(int id) {
        Trip trip=tripMapper.selectByPrimaryKey(id);
        City city=cityMapper.selectByPrimaryKey(trip.getStartPlace());
        if(city != null)
            trip.setStart(city);
        Sequence sequence=sequenceMapper.selectByPrimaryKey(trip.getType());
        if(sequence != null)
            trip.setSeqType(sequence);
        Schedule schedule=scheduleMapper.selectByTripId(trip.getId());
        List<Dates> dates=datesMapper.selectByTripId(trip.getId());
        schedule.setDates(dates);
        trip.setSchedule(schedule);
        Set<Trippicture> tplist=trippictureMapper.selectByTripId(trip.getId());
        trip.setPic_list(tplist);
        List<Price> plist=priceMapper.selectPriceByTripId(trip.getId());
        trip.setPrice_list(plist);
        List<Placeontrip> ptlist=placeontripMapper.selectByTripId(trip.getId());
        for (int i = 0; i < ptlist.size(); i++) {

            Place place=placeMapper.selectByPrimaryKey(ptlist.get(i).getPlace());
            ptlist.get(i).setPlaceObject(place);
        }
        trip.setPlaceontrip_list(ptlist);
        Position position=positionMapper.selectByPrimaryKey(trip.getPosition());
        trip.setPositionObject(position);
        Detail detail =detailMapper.selectByTripId(trip.getId());
        trip.setDetail(detail);
        return trip;
    }



    //
    @Override
    public List<Trip> getSearchTripsByVo(SearchForm vo) {
        packageForm(vo);
        PageHelper.startPage(vo.getPageCurrent(),5);
        // List<Trip> allTripList = tripMapper.selectByCondition(vo);
        List<Trip> list = tripMapper.selectByCondition(vo);
        PageInfo<Trip> pageInfo=new PageInfo<Trip>(list);//分页
        List<Trip> allTripList=pageInfo.getList();
        vo.setMaxPage(pageInfo.getPages());
        vo.setTotalResult((int)pageInfo.getTotal());
        for (int i = 0; i < allTripList.size(); i++) {
            Trip trip=allTripList.get(i);
            trip.setStart(cityMapper.selectByPrimaryKey(trip.getStartPlace()));
            trip.setSeqType(sequenceMapper.selectByPrimaryKey(trip.getType()));
            List<Themeontrip> ttlist=themeontripMapper.selectByTripId(trip.getId());
            for (int j = 0; j <ttlist.size() ; j++) {
                ttlist.get(j).setThemeObject(themeMapper.selectByPrimaryKey(ttlist.get(j).getTheme()));
            }
            trip.setThemeontrip_list(ttlist);
            List<Placeontrip> ptlist =placeontripMapper.selectByTripId(trip.getId());
            for (int j = 0; j <ptlist.size() ; j++) {
                ptlist.get(j).setPlaceObject(placeMapper.selectByPrimaryKey(ptlist.get(j).getPlace()));
            }
            trip.setPlaceontrip_list(ptlist);
            Set<Trippicture> tplist=trippictureMapper.selectByIdandType(trip.getId(),0);
            trip.setPic_list(tplist);
            trip.setPrice_list(priceMapper.selectPriceByTripId(trip.getId()));
        }
        return allTripList;
    }

    private void packageForm(SearchForm vo) {
        // 如果行程类型字符串不为空，获取该行程类型的id
        if (vo.getType_name() != null) {
            String typename = vo.getType_name();

            Sequence s = sequenceMapper.selectByValue(typename);
            if (s == null) {
                typename = Utils.isoToUtf(typename);
                vo.setType_name(typename);
                s = sequenceMapper.selectByValue(typename);
            }
            vo.setType_id(s.getId());
        }
        // 如果出发地字符串不为空，获取该出发地的id
        if (vo.getStart_place_name() != null) {

            List<City> citys = cityMapper.selectCityByName(vo.getStart_place_name());
            for (int i = 0; i <citys.size() ; i++) {
                if(citys.get(i).getParentId()!=null)
                    citys.get(i).setParentCity(cityMapper.selectByPrimaryKey(citys.get(i).getParentId()));
            }
            List<Integer> cidList = new ArrayList<>();
            if (citys != null) {
                for(City city : citys){
                    cidList.add(city.getId());
                }
            }
            vo.setStart_place_id_list(cidList);
        }
        // 如果景点地区字符串不为空，获取该景点地区的id
        if (vo.getPlace_name() != null) {

            List<Place> pList = placeMapper.selectPlaceByName(vo.getPlace_name());
            List<Integer> pidList = new ArrayList<>();
            if (pList != null && !pList.isEmpty()) {
                for (Place p : pList) {
                    pidList.add(p.getId());
                }
            }
            vo.setPlace_id_list(pidList);
        }
        // 如果主题字符串不为空，获取该主题的id
        if (vo.getTheme_name() != null) {

            List<Theme> tList = themeMapper.selectByName(vo.getTheme_name());
            List<Integer> tidList = new ArrayList<>();
            if (tList != null && !tList.isEmpty()) {
                for (Theme t : tList) {
                    tidList.add(t.getId());
                }
            }
            vo.setTheme_id_list(tidList);
        }
    }
}
