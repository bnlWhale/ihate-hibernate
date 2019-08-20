package com.juiceman.ihatehibernate.ihatehiberatedemo.model;

import javax.persistence.Embeddable;

@Embeddable
public class Dimensions {

    private int length;

    private int width;


    public Dimensions(){
        super();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
