package com.demo.alpha.domen;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;

@Data
@Entity
@Table(name = "BOX")
@XmlAccessorType(XmlAccessType.FIELD)
public class Box {
    @Id
    @Column(name = "ID")
    @XmlAttribute(name = "id")
    private int id;

    @Column(name = "CONTAINED IN")
    private int containedIn;

    @OneToMany(mappedBy = "box", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Item> items;
}
