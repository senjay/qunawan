package com.finalwork.qunawan.utils;

import com.finalwork.qunawan.globle.Constants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class UserAccessRecorder {

	// 首页的访问次数
	private Integer INDEX_ACCESS_NUM = 0;
	// 搜索页的访问次数
	private Integer SEARCH_ACCESS_NUM = 0;
	// 旅游详情页的访问次数
	private Integer TRIP_DETAIL_ACCESS_NUM = 0;
	// 用于存放页面访问次数和访问时间的HashMap集合
	private Map<String, String> accessMap = new HashMap<>();
	// 用于对Map集合进行时间正排序的ArrayList集合
	private ArrayList<Map.Entry<String, String>> accessList = null;

	/**
	 * 把Map对象放到List中，并通过时间字符串进行正排序
	 * @return 按时间正排序的List
	 */
	public List<Map.Entry<String, String>> getAccessList() {
		// 通过存放访问记录的Map的entry集合实例化ArrayList对象
		accessList = new ArrayList<>(accessMap.entrySet());
		/*
		 * 对该List集合进行排序 排序器比较器是一个匿名内部类 通过entry的时间字符串进行比较排序
		 */
		Collections.sort(accessList, new Comparator<Map.Entry<String, String>>() {
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		return accessList;
	}

	/**
	 * 记录访问页面的时间和次数
	 * @param page 访问页面的常量
	 */
	public void setAccessMap(String page) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 当前访问的是主页
		if (page.equals(Constants.INDEX_PAGE))
			accessMap.put(page + ":" + ++INDEX_ACCESS_NUM, sdf.format(new Date()));
		// 当前访问的是搜索页
		else if (page.equals(Constants.SEARCH_PAGE))
			accessMap.put(page + ":" + ++SEARCH_ACCESS_NUM, sdf.format(new Date()));
		// 当前访问的是旅游详情页
		else
			accessMap.put(page + ":" + ++TRIP_DETAIL_ACCESS_NUM, sdf.format(new Date()));
	}
}
