package com.finalwork.qunawan.pojo;

public class Placeontrip {
    private Place placeObject;

    public Place getPlaceObject() {
        return placeObject;
    }

    public void setPlaceObject(Place placeObject) {
        this.placeObject = placeObject;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column placeontrip.id
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column placeontrip.place
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer place;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column placeontrip.trip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    private Integer trip;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column placeontrip.id
     *
     * @return the value of placeontrip.id
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column placeontrip.id
     *
     * @param id the value for placeontrip.id
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column placeontrip.place
     *
     * @return the value of placeontrip.place
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getPlace() {
        return place;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column placeontrip.place
     *
     * @param place the value for placeontrip.place
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setPlace(Integer place) {
        this.place = place;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column placeontrip.trip
     *
     * @return the value of placeontrip.trip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public Integer getTrip() {
        return trip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column placeontrip.trip
     *
     * @param trip the value for placeontrip.trip
     *
     * @mbg.generated Tue Jun 18 13:55:50 CST 2019
     */
    public void setTrip(Integer trip) {
        this.trip = trip;
    }
}