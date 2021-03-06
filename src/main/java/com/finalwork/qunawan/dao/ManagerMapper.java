package com.finalwork.qunawan.dao;

import com.finalwork.qunawan.pojo.Manager;
import java.util.List;

public interface ManagerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int insert(Manager record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    Manager selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    List<Manager> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int updateByPrimaryKey(Manager record);
}