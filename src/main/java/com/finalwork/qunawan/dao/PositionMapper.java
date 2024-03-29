package com.finalwork.qunawan.dao;

import com.finalwork.qunawan.pojo.Position;
import org.springframework.stereotype.Component;

import java.util.List;
@Component(value = "positionMapper")
public interface PositionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int insert(Position record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    Position selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    List<Position> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int updateByPrimaryKey(Position record);

}