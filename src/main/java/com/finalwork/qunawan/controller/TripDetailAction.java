package com.finalwork.qunawan.controller;

import com.finalwork.qunawan.globle.Constants;
import com.finalwork.qunawan.globle.Globle;
import com.finalwork.qunawan.pojo.Comment;
import com.finalwork.qunawan.pojo.Commentpicture;
import com.finalwork.qunawan.pojo.Trip;
import com.finalwork.qunawan.pojo.User;
import com.finalwork.qunawan.service.*;
import com.finalwork.qunawan.utils.ControllerUtil;
import com.finalwork.qunawan.utils.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * author: 钱苏涛
 * created on: 2019/6/18 20:43
 * description:
 */
@Controller
public class TripDetailAction {
    @Autowired
    SequenceService sequenceService;
    @Autowired
    TripService tripService;
    @Autowired
    PlaceService placeService;
    @Autowired
    ThemeService themeService;
    @Autowired
    CommentService commentService;
    @RequestMapping(value = "/tripDetail",method =RequestMethod.GET )
    public String getTripDetail(String id, String type, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // 如果参数不合法，则跳转到首页
        if (type == null||id==null)
            return "redirect:/index";

        int tripid=Integer.parseInt(id);

        // 产品详情页初始化
        if (type.equals("init")) {
            // 通过产品id获得该产品对象
            Trip trip = tripService.getTripById(tripid);
            // 初始化产品画廊的图片并加载到缓存
            tripService.initTripPicture(trip.getPic_list(),
                    ResourceUtils.getURL("classpath:").getPath());

            HttpSession session = (HttpSession) request.getSession();
            // 把产品对象存到session中
            session.setAttribute("detail", trip);
            // 把产品评论总数存到session中
            session.setAttribute("num", commentService.getCommentByTripId(tripid));

            // 如果当前用户已登录，则记录访问旅游详情页的时间和次数
            if (request.getSession().getAttribute(Constants.USER_KEY) != null) {
                // 获取用户id
                User user = (User) request.getSession().getAttribute(Constants.USER_KEY);
                // 添加详情页访问记录
                Globle.addAccessRecord(user.getId(), Constants.TRIP_DETAIL_PAGE);
            }

            return "pages/trip_detail";
         }
        return "redirect:/index";
    }
    @RequestMapping(value = "/tripDetail", method= RequestMethod.POST)
    public void setgoodOrBad(String id, String type, String isUsefull,HttpServletRequest request, HttpServletResponse response)throws  Exception
    {
        int tripid=Integer.parseInt(id);
        // 产品-评论分页查询
        if (type.equals("comment")) {
            // 获取要显示的页码数
            String pageStr = request.getParameter("page");
            Integer page = Utils.getPageNum(pageStr);

            PageHelper.startPage(page,4);

            // 获取指定页的评论集合
            List<Comment> comments = commentService.getCommentsByTripId(tripid);

            PageInfo<Comment> pageInfo=new PageInfo<Comment>(comments);//分页
            // 初始化评论图片
            for (Comment c : pageInfo.getList()) {
                Set<Commentpicture> pictures = c.getPictures();
                commentService.initCommentPicture(pictures, ResourceUtils.getURL("classpath:").getPath());
            }
            ControllerUtil.out(response, pageInfo.getList());
        }
        if (type.equals("goodOrBad")) {

            boolean isUsefull_tmp = Boolean.parseBoolean(isUsefull);
            ControllerUtil.out(response, "" + commentService.updateUseful(tripid, isUsefull_tmp));
        }
    }

}
