package com.juiceman.ihatehibernate.ihatehiberatedemo.model;

import javax.persistence.*;
import java.io.Serializable;



@Entity(name = "Captain")
@Table(name = "Captain")
public class Captain {

    @EmbeddedId
    private Identity id;

    public Captain(){
        super();
    }

    public Identity getId() {
        return id;
    }

    public void setId(Identity id) {
        this.id = id;
    }
}