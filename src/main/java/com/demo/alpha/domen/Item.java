package com.demo.alpha.domen;

import javax.xml.bind.annotation.XmlRootElement;


public class Item {

    private int id;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
