package com.finalwork.qunawan.dao;

import com.finalwork.qunawan.pojo.Commentpicture;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component(value = "commentpictureMapper")
public interface CommentpictureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commentpicture
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commentpicture
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int insert(Commentpicture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commentpicture
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    Commentpicture selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commentpicture
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    List<Commentpicture> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commentpicture
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    int updateByPrimaryKey(Commentpicture record);

    Set<Commentpicture> selectByCommentId(int commentid);
}