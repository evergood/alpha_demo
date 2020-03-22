package com.demo.alpha.domen;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@Entity
@Table(name = "BOX")
@XmlAccessorType(XmlAccessType.FIELD)
public class Box {

    @Id
    @Column(name = "ID")
    @XmlAttribute(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "box", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @XmlElement(name = "Item")
    private List<Item> items;

    @OneToMany(mappedBy = "parentBox", cascade = CascadeType.ALL)
    @XmlElement(name = "Box")
    private List<Box> boxes;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTAINED_IN")
    private Box parentBox;

    public void afterUnmarshal(Unmarshaller u, Object parent) {
        if (parent instanceof Box) {
            this.parentBox = (Box) parent;
        }
    }
}
