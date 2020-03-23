package com.demo.alpha.domen;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@Entity
@SqlResultSetMapping(name = "ItemResults",
        entities = {
                @EntityResult(entityClass = Item.class, fields = {
                        @FieldResult(name = "id", column = "ID"),
                        @FieldResult(name = "color", column = "COLOR"),
                        @FieldResult(name = "box", column = "id")})})
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
