package com.dastan.tezbus;

import java.io.Serializable;

public class Travel implements Serializable {
    private String id;
    private String date;
    private String time;
    private String direction;
    private String price;
    private String info;

    public Travel(String id, String date, String time, String direction, String price, String info) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.direction = direction;
        this.price = price;
        this.info = info;
    }

    public Travel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
