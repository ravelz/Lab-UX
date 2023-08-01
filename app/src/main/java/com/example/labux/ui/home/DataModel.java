package com.example.labux.ui.home;

import java.io.Serializable;

public class DataModel implements Serializable {

    public String title, time, location, description;
    public Integer price;
    public String date;
    public int drawable;
    public int drawableSlider;
    public String color;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getColor() {
        return color;
    }

    public int getDrawableSlider() {
        return drawableSlider;
    }

    public void setDrawableSlider(int drawableSlider) {
        this.drawableSlider = drawableSlider;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public DataModel(String t, Integer p, String date, int d, int drawableSlider, String time, String location, String description)
    {
        title=t;
        price = p;
        this.date = date;
        drawable=d;
        this.time = time;
        this.location = location;
        this.description = description;
        this.drawableSlider = drawableSlider;
    }

}
