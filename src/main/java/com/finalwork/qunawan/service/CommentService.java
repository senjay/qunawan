package com.finalwork.qunawan.service;

import com.finalwork.qunawan.globle.Constants;
import com.finalwork.qunawan.pojo.Comment;
import com.finalwork.qunawan.pojo.Commentpicture;

import java.util.List;
import java.util.Set;

/**
 * author: 钱苏涛
 * created on: 2019/6/19 8:55
 * description:
 */
public interface CommentService {
    public  int getCommentByTripId(int tripid);
    public List<Comment> getCommentsByTripId(int tripid);
    public void initCommentPicture(Set<Commentpicture> pictures, String basePath);
    public  int updateUseful(int id, Boolean isUsefull);
    public  int getCommentedCountByUser(int userid);

}
