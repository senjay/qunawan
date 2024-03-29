package com.finalwork.qunawan.dao;

import com.finalwork.qunawan.pojo.Placeontrip;
import org.springframework.stereotype.Component;


import java.util.List;

@Component(value = "placeontripMapper")
public interface PlaceontripMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table placeontrip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table placeontrip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int insert(Placeontrip record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table placeontrip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    Placeontrip selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table placeontrip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    List<Placeontrip> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table placeontrip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int updateByPrimaryKey(Placeontrip record);

    public List<Placeontrip> selectByTripId(int tripid);
}