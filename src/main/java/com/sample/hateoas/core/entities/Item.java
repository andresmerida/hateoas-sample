package com.sample.hateoas.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by andresmerida on 4/4/2016.
 */

@Entity
@Table(name = "Item")
public class Item extends AbstractAuditingEntity implements Serializable{
    // TODO should be deleted this entity
    private static final long serialVersionUID = 141481953116476081L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    protected Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
