package com.finalwork.qunawan.service.impl;

import com.finalwork.qunawan.dao.CommentMapper;
import com.finalwork.qunawan.dao.CommentpictureMapper;
import com.finalwork.qunawan.pojo.Comment;
import com.finalwork.qunawan.pojo.Commentpicture;
import com.finalwork.qunawan.service.CommentService;
import com.finalwork.qunawan.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * author: 钱苏涛
 * created on: 2019/6/19 8:55
 * description:
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentpictureMapper commentpictureMapper;
    @Override
    public int getCommentByTripId(int tripid) {
        return commentMapper.selectCountByTripId(tripid);
    }

    @Override
    public List<Comment> getCommentsByTripId(int tripid) {
        List<Comment> list= commentMapper.selectByTripId(tripid);
        for (int i = 0; i <list.size() ; i++) {
            Set<Commentpicture> pics= commentpictureMapper.selectByCommentId(list.get(i).getId());
            list.get(i).setPictures(pics);
        }
        return  list;
    }

    @Override
    public void initCommentPicture(Set<Commentpicture> pictures, String basePath) {
        if (pictures == null || pictures.size() == 0) {
            return;
        }
        for (Commentpicture cp : pictures) {
            String path = basePath + "image_cache\\" + cp.getName();
            if (!new File(path).exists()) {
                Utils.getFile(cp.getData(), path);
            }
        }
    }

    @Override
    public int updateUseful(int id, Boolean isUsefull) {
        int num;
        if(isUsefull)
        {
            num=commentMapper.selectUsefullCountByid("usefull",id)+1;
            commentMapper.updateIsUsefull("usefull",num,id);
        }
        else
        {
            num=commentMapper.selectUsefullCountByid("useless'",id)+1;
            commentMapper.updateIsUsefull("useless",num,id);
        }
        return num;
    }

    @Override
    public int getCommentedCountByUser(int userid) {
        return commentMapper.selectCountByUserId(userid);
    }

}
