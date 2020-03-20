package com.demo.alpha.domen;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "Storage")
@XmlAccessorType(XmlAccessType.FIELD)
public class Storage {
    @XmlElement(name = "Box")
    List<Box> boxes;

    @XmlElement(name = "Item")
    List<Item> items;
}
