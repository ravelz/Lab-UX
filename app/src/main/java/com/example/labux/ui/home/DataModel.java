package com.example.labux.ui.home;

import java.io.Serializable;

public class DataModel implements Serializable {

    public String title, time, location, description;
    public Integer price;
    public String date;
    public int drawable;
    public String color;

    public DataModel(String t, Integer p, String date, int d, String time, String location, String description)
    {
        title=t;
        price = p;
        this.date = date;
        drawable=d;
        this.time = time;
        this.location = location;
        this.description = description;
    }

}
