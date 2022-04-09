package com.lz.entity;

public class Car {
    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                '}';
    }

    public void setColor(String color) {

        this.color = color;
    }
}
