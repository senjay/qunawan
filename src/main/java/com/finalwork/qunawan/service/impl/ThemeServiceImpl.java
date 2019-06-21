package com.finalwork.qunawan.service.impl;

import com.finalwork.qunawan.dao.ThemeMapper;

import com.finalwork.qunawan.pojo.Theme;
import com.finalwork.qunawan.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author: 钱苏涛
 * created on: 2019/6/18 16:03
 * description:
 */
@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    ThemeMapper themeMapper;
    @Override
    public List<String> getThemenameByType(int type) {
        List<String> list=new ArrayList<String>();
        List<Theme> themes=themeMapper.selectByType(type);
        for (int i = 0; i < themes.size(); i++) {
            list.add(themes.get(i).getName());
        }
        return list;
    }
}
