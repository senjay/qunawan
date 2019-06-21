package com.finalwork.qunawan.dao;

import com.finalwork.qunawan.form.SearchForm;
import com.finalwork.qunawan.pojo.Trip;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value="tripMapper")
public interface TripMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trip
     *
     * @mbg.generated Tue Jun 18 11:34:45 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trip
     *
     * @mbg.generated Tue Jun 18 11:34:45 CST 2019
     */
    int insert(Trip record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trip
     *
     * @mbg.generated Tue Jun 18 11:34:45 CST 2019
     */
    Trip selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trip
     *
     * @mbg.generated Tue Jun 18 11:34:45 CST 2019
     */
    List<Trip> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trip
     *
     * @mbg.generated Tue Jun 18 11:34:45 CST 2019
     */
    int updateByPrimaryKey(Trip record);


    List<Trip> seletByType(int type);
    List<Trip>selectByCondition(@Param("vo") SearchForm vo);

}