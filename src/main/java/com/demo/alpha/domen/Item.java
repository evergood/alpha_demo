package com.demo.alpha.domen;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@Entity
@Table(name = "ITEM")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @Id
    @Column(name = "ID")
    @XmlAttribute(name = "id")
    private int id;

    @Column(name = "COLOR")
    @XmlAttribute(name = "color")
    private String color;

    @Column(name = "CONTAINED IN")
    private int containedIn;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTAINED_IN")
    private Box box;
}
