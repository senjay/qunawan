package com.finalwork.qunawan.pojo;

import java.util.Date;

public class Orders {
    private User userObject;


    public User getUserObject() {
        return userObject;
    }

    public void setUserObject(User userObject) {
        this.userObject = userObject;
    }

    private Trip tripObject;

    public Trip getTripObject() {
        return tripObject;
    }

    public void setTripObject(Trip tripObject) {
        this.tripObject = tripObject;
    }

    public Sequence getSequence() {
        return sequence;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    private  Sequence sequence;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private  String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.id
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.orderNo
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private String orderno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.trip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer trip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.num
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer num;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.start_time
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Date startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.go_point
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private String goPoint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.go_time
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private String goTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.total_price
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Float totalPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.state
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.create_time
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.user
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer user;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.id
     *
     * @return the value of orders.id
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.id
     *
     * @param id the value for orders.id
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.orderNo
     *
     * @return the value of orders.orderNo
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.orderNo
     *
     * @param orderno the value for orders.orderNo
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.trip
     *
     * @return the value of orders.trip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getTrip() {
        return trip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.trip
     *
     * @param trip the value for orders.trip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setTrip(Integer trip) {
        this.trip = trip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.num
     *
     * @return the value of orders.num
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.num
     *
     * @param num the value for orders.num
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.start_time
     *
     * @return the value of orders.start_time
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.start_time
     *
     * @param startTime the value for orders.start_time
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.go_point
     *
     * @return the value of orders.go_point
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public String getGoPoint() {
        return goPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.go_point
     *
     * @param goPoint the value for orders.go_point
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setGoPoint(String goPoint) {
        this.goPoint = goPoint == null ? null : goPoint.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.go_time
     *
     * @return the value of orders.go_time
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public String getGoTime() {
        return goTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.go_time
     *
     * @param goTime the value for orders.go_time
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setGoTime(String goTime) {
        this.goTime = goTime == null ? null : goTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.total_price
     *
     * @return the value of orders.total_price
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Float getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.total_price
     *
     * @param totalPrice the value for orders.total_price
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.state
     *
     * @return the value of orders.state
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.state
     *
     * @param state the value for orders.state
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.create_time
     *
     * @return the value of orders.create_time
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.create_time
     *
     * @param createTime the value for orders.create_time
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.user
     *
     * @return the value of orders.user
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getUser() {
        return user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.user
     *
     * @param user the value for orders.user
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setUser(Integer user) {
        this.user = user;
    }
}