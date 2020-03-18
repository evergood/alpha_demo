package com.demo.alpha.domen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @XmlAttribute(name = "id")
    private int id;
    @XmlAttribute(name = "color")
    private String color;
}
