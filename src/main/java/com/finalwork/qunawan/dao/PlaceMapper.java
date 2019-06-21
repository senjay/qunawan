package com.finalwork.qunawan.dao;

import com.finalwork.qunawan.pojo.Place;
import org.springframework.stereotype.Component;

import java.util.List;
@Component(value="placeMapper")
public interface PlaceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbg.generated Tue Jun 18 11:34:45 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbg.generated Tue Jun 18 11:34:45 CST 2019
     */
    int insert(Place record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbg.generated Tue Jun 18 11:34:45 CST 2019
     */
    Place selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbg.generated Tue Jun 18 11:34:45 CST 2019
     */
    List<Place> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbg.generated Tue Jun 18 11:34:45 CST 2019
     */
    int updateByPrimaryKey(Place record);

    List<Place> selectByType(int type);
    List<Place> selectPlaceByName(String name);
}