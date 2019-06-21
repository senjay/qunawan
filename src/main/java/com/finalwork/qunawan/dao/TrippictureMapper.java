package com.finalwork.qunawan.dao;

import com.finalwork.qunawan.pojo.Trippicture;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component(value="trippictureMapper")
public interface TrippictureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trippicture
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trippicture
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int insert(Trippicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trippicture
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    Trippicture selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trippicture
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    List<Trippicture> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trippicture
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int updateByPrimaryKey(Trippicture record);

    Set<Trippicture> selectByIdandType(@Param("trip") Integer  trip, @Param("type") Integer  type);
    Set<Trippicture> selectByTripId(int tripid);

}