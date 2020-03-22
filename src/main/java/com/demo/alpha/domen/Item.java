package com.demo.alpha.domen;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.Unmarshaller;
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
    private Integer id;

    @Column(name = "COLOR")
    @XmlAttribute(name = "color")
    private String color;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTAINED_IN")
    private Box box;

    public void afterUnmarshal(Unmarshaller u, Object parent) {
        if (parent instanceof Box) {
            this.box = (Box) parent;
        }
    }
}
