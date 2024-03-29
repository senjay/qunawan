package com.finalwork.qunawan.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Comment {



    private String username;
    private Set<Commentpicture> pictures;
    private String timeStr;

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Set<Commentpicture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Commentpicture> pictures) {
        this.pictures = pictures;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.id
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.user
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer user;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.trip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer trip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.orders
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer orders;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.place
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer place;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.hotel
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer hotel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.service
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer service;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.traffic
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer traffic;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.content
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.time
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.usefull
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer usefull;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.useless
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer useless;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.id
     *
     * @return the value of comment.id
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.id
     *
     * @param id the value for comment.id
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.user
     *
     * @return the value of comment.user
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getUser() {
        return user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.user
     *
     * @param user the value for comment.user
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setUser(Integer user) {
        this.user = user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.trip
     *
     * @return the value of comment.trip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getTrip() {
        return trip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.trip
     *
     * @param trip the value for comment.trip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setTrip(Integer trip) {
        this.trip = trip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.orders
     *
     * @return the value of comment.orders
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getOrders() {
        return orders;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.orders
     *
     * @param orders the value for comment.orders
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.place
     *
     * @return the value of comment.place
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getPlace() {
        return place;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.place
     *
     * @param place the value for comment.place
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setPlace(Integer place) {
        this.place = place;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.hotel
     *
     * @return the value of comment.hotel
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getHotel() {
        return hotel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.hotel
     *
     * @param hotel the value for comment.hotel
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setHotel(Integer hotel) {
        this.hotel = hotel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.service
     *
     * @return the value of comment.service
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getService() {
        return service;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.service
     *
     * @param service the value for comment.service
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setService(Integer service) {
        this.service = service;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.traffic
     *
     * @return the value of comment.traffic
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getTraffic() {
        return traffic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.traffic
     *
     * @param traffic the value for comment.traffic
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.content
     *
     * @return the value of comment.content
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.content
     *
     * @param content the value for comment.content
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.time
     *
     * @return the value of comment.time
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.time
     *
     * @param time the value for comment.time
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setTime(Date time) {
        this.time = time;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeStr = df.format(time);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.usefull
     *
     * @return the value of comment.usefull
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getUsefull() {
        return usefull;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.usefull
     *
     * @param usefull the value for comment.usefull
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setUsefull(Integer usefull) {
        this.usefull = usefull;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.useless
     *
     * @return the value of comment.useless
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getUseless() {
        return useless;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.useless
     *
     * @param useless the value for comment.useless
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setUseless(Integer useless) {
        this.useless = useless;
    }
}