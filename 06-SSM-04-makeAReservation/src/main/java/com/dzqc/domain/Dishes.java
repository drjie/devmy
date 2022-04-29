package com.dzqc.domain;

/**
 * 菜品实体类
 */
public class Dishes {

    private int id;
    private String dishName; //菜品名称
    private double price; //菜品价格
    private int praiseNum; //点赞数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(int praiseNum) {
        this.praiseNum = praiseNum;
    }
}
