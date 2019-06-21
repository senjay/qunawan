package com.finalwork.qunawan.controller;

import com.finalwork.qunawan.form.WaitCommentForm;
import com.finalwork.qunawan.globle.Constants;
import com.finalwork.qunawan.pojo.*;
import com.finalwork.qunawan.service.*;

import com.finalwork.qunawan.utils.ControllerUtil;
import com.finalwork.qunawan.utils.Utils;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;

import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * @ClassName PersonalAction
 * Description TODO
 * @Author 俞立栋
 * Date 2019/6/18 20:56
 */
@Controller

@RequestMapping("/personal")
public class PersonalAction {
    @Autowired
    UserService userService;
    @Autowired
    CityService cityService;
    @Autowired
    OrdersService ordersService;
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
    //查看个人基本信息
    @RequestMapping("/personalinf")
    public String personInfo(HttpSession session){
        List<City> provinces = cityService.getAllCity(1);
        session.setAttribute("provinces", provinces);
        User temp=(User)session.getAttribute(Constants.USER_KEY);
        City city=cityService.getCity(temp.getCity());
        session.setAttribute("city",city);
        return "/pages/personal/personal_information";
    }
    //修改个人基本信息
    @RequestMapping("/updateinf")
    public String personInfoUpdate(User user, String sel_year, String sel_month, String sel_day, HttpSession session, RedirectAttributes attr){
//        List<City> provinces = cityService.getProvinces();
//        request.getSession(true).setAttribute("provinces", provinces);
        User temp=(User)session.getAttribute(Constants.USER_KEY);
        user.setId(temp.getId());
        user.setPassword(temp.getPassword());
        user.setImgPath(temp.getImgPath());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(sel_year+"-"+sel_month+"-"+sel_day, pos);
        user.setBirthday(strtodate);
        userService.upDate(user);
        City city=cityService.getCity(user.getCity());
        session.setAttribute("city",city);
        session.setAttribute(Constants.USER_KEY,user);
        return "/pages/personal/personal_information";
    }
    //进入修改页面界面
    @RequestMapping("/intoPwd")
    public String intoPwd(){
        return "/pages/personal/personal_passwordChange";
    }
    //进入我的点评
    @RequestMapping(value="/myComments",method = RequestMethod.GET )
    public String intoMyComments(HttpSession session){
        return "/pages/personal/personal_myComments";
    }
    //我的点评获取数据
    @RequestMapping(value = "/commentDate", method= RequestMethod.POST)
    public void showContact(HttpServletRequest request, HttpServletResponse response)throws  Exception{
        String type = request.getParameter("type");
        String pageStr = request.getParameter("page");

        User user = (User) request.getSession().getAttribute(Constants.USER_KEY);
        int userId = user.getId();


        Sequence sq_to_comment = sequenceService.getSeqByKeyAndType(Constants.WAIT_COMMENT_ORDER_STATE,
                Constants.ORDER_TYPE);
        Sequence sq_commented = sequenceService.getSeqByKeyAndType(Constants.COMMENTED_ORDER_STATE, Constants.ORDER_TYPE);

        int waitCount = ordersService.getOrdersbyUserandSeqType(user.getId(),sq_to_comment.getId());
        int finishCount = commentService.getCommentedCountByUser(user.getId());

        // 获取待评论的订单数据
        if (Constants.COMMENT_GET_WAIT_COMMENTS.equals(type)) {
            getWaitComments(userId,pageStr, waitCount, finishCount, sq_to_comment, sq_commented,response);
        }
//        // 获取已经评论的评论数据
//        if (Constants.COMMENT_GET_FINISH_COMMENT.equals(type)) {
//            getFinishComment(pageStr, sq_commented.getId(), finishCount);
//        }
//        // 提交评论
//        if (Constants.COMMENT_SUBMIT_COMMENT.equals(type)) {
//            submitComment();
//        }

    }
    private void getWaitComments(int userId,String pageStr, int waitCount, int finishCount,
                                 Sequence sq_to_comment, Sequence sq_commented, HttpServletResponse response) throws  Exception{
        int page = Utils.getPageNum(pageStr);
        // 总页码数
        int pageCount = (int) Math.ceil((double) waitCount / Constants.COMMENT_MAX);

        // 获取该用户待评价的订单集合

        List<Orders> orderList = ordersService.getOrders(userId, sq_to_comment.getId());



        List<WaitCommentForm> formList = new ArrayList<WaitCommentForm>();
        // 把每个订单对象的属性封装到用于页面显示的表单集合中
        for (Orders order : orderList) {

            WaitCommentForm wco = new WaitCommentForm(order, pageCount, waitCount, finishCount,
                    commentService.getCommentByTripId(order.getTripObject().getId()));

            tripService.initTripPicture(order.getTripObject().getPic_list(), ResourceUtils.getURL("classpath:").getPath());
            formList.add(wco);
        }
        if (orderList.size() == 0) {
            WaitCommentForm wco = new WaitCommentForm(waitCount, finishCount);
            formList.add(wco);
        }
        ControllerUtil.out(response, formList);
    }

    //进入我的约单
    @RequestMapping("/myOrder")
    public String intoMyOrder(HttpSession session ,HttpServletRequest request,String page){
        Integer pagenum = Utils.getPageNum(page);
        PageHelper.startPage(pagenum,8);
        List<Orders> orders=ordersService.getOrdersByUid((int)session.getAttribute("userId"));
//        for(int i=0;i<orders.size();i++){
//            //log.info(orders.get(i).toString());
//        }
        PageInfo<Orders> pageInfo=new PageInfo<Orders>(orders);//分页
        request.setAttribute("orderFormList",pageInfo.getList());
        request.setAttribute("pageCount", pageInfo.getTotal() != 0 ?pageInfo.getPages() : 1);
        request.setAttribute("cur", Utils.getPageNum(request.getParameter("page")));
        //session.setAttribute("orderFormList",orders);
        return "/pages/personal/personal_myOrder";
    }
    //进入常用联系人
    @RequestMapping("/myContacts")
    public String intoMyContacts(){
        return "/pages/personal/personal_myContact";
    }
    //修改密码
    @RequestMapping("/updatepwd")
    public String updatePassword(String oldPassWord, String newPassWord, String newPassWordt, HttpServletRequest request) {
        User user = (User) request.getSession(true).getAttribute(Constants.USER_KEY);
        System.out.println(oldPassWord + "   " + newPassWord + "    " + newPassWordt + "ID: " + user.getId());
        System.out.println();
        if (user.getPassword().equals(Utils.toMD5(oldPassWord)) == false) {
            request.setAttribute("pw_error", "原密码错误");
            return "pages/personal/personal_passwordChange";
        } else if (newPassWord.equals(newPassWordt) == false) {
            request.getSession(true).setAttribute("pw_error", "新密码不一致");
            return "pages/personal/personal_passwordChange";
        } else {
            userService.updatePassword(user.getId(),Utils.toMD5(newPassWord));
            request.getSession(true).removeAttribute(Constants.USER_KEY);
            return "redirect:/";
        }
    }
    //修改头像
    @RequestMapping("/CropAction")
    public String setHeadPic(HttpServletRequest request) throws  Exception
    {

        User user =  (User) request.getSession().getAttribute(Constants.USER_KEY);

        String flag = request.getParameter("pictureType");

        switch (flag) {
            case "headPic":
                return getUserHeadPic(user,request);

            case "commentPic":
               // getCommentPic(user.getId());
                break;
            default:
                break;
        }
        return null;
    }


    public  String  getUserHeadPic(User user,HttpServletRequest request) throws Exception {

        /** 实训场景006：用户头像上传 - 上传并保存头像【START】 */
        // 解析表单数据并得到用户裁剪后上传的图片
        BufferedImage image = receiveImage(request);

        String file_name = Utils.createName()+".jpg";
        String prepath=new File("src/main/webapp/img/user_img").getCanonicalPath().replace("\\","/")+ "/";
        File file = new File(prepath+file_name);
        ImageIO.write(image, "png", file);

        if(user.getImgPath()!=null)
        {
            File oldhead=new File(prepath+user.getImgPath());
            if(oldhead.exists()&&oldhead.isFile())
                oldhead.delete();
        }
        user.setImgPath(file_name);

        // 保存用户对象
        userService.upDate(user);
        /** 实训场景006：用户头像上传 - 上传并保存头像【END】 */

        // 跳转到个人页面
        return "redirect:/personal/personalinf";
    }
    private BufferedImage receiveImage(HttpServletRequest request) {

        /** 实训场景006：用户头像上传 - 解析请求数据并裁剪图片【START】 */
        // 表单上传数据集合
        List<FileItem> items = null;
        // 上传图片
        BufferedImage bi = null;

        // 实例化文件工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 用于文件上传的对象实例
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 解析请求中的请求数据
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        // 如果上传数据为空则返回null
        if (items == null || items.size() == 0)
            return null;

        // 截图左上角左边和宽高
        int x1 = 0, y1 = 0, w = 0, h = 0;
        // 原始图和截图界面的缩放图的比例
        float ratio = 0;

        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            // 如果是表单域 ，就是非文件上传元素
            if (item.isFormField()) {
                String name = item.getFieldName();
                String value = item.getString();
                // 设置截图左上角的x坐标
                if (name.equals("x1"))
                    x1 = Integer.parseInt("".equals(value) ? "0" : value);
                // 设置截图左上角的y坐标
                if (name.equals("y1"))
                    y1 = Integer.parseInt("".equals(value) ? "0" : value);
                // 设置截图的宽
                if (name.equals("w"))
                    w = Integer.parseInt("".equals(value) ? "0" : value);
                // 设置截图的高
                if (name.equals("h"))
                    h = Integer.parseInt("".equals(value) ? "0" : value);
                // 设置原始图和截图界面缩放图的比例
                if (name.equals("ratio"))
                    ratio = Float.parseFloat("".equals(value) ? "0" : value);
            }
            // 如果是二进制文件流
            else {
                // 把二进制流转化为图片缓存对象
                try {
                    bi = ImageIO.read(item.getInputStream());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        // 如果缓存图片不为空，则根据截图界面的坐标和宽高对原始图进行相应的裁剪
        if (null != bi)
            bi = cut(bi, (int) (x1 * ratio), (int) (y1 * ratio), (int) (w * ratio), (int) (h * ratio));

        // 返回裁剪后的图片
        return bi;
        /** 实训场景006：用户头像上传 - 解析请求数据并裁剪图片【END】 */
    }

    private BufferedImage cut(BufferedImage bi, int x1, int y1, int width, int height) {
        int srcWidth = bi.getWidth();
        int srcHeight = bi.getHeight();
        if (srcWidth <= 0 || srcHeight <= 0)
            return null;

        // 获取传入的Image资源图
        Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
        ImageFilter cropFilter = new CropImageFilter(x1, y1, width, height);
        // Image进行裁剪
        Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 创建画布，并绘制Image
        Graphics g = result.getGraphics();
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();

        return result;
    }
}
