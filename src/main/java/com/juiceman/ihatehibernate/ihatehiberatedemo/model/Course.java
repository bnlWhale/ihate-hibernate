package com.juiceman.ihatehibernate.ihatehiberatedemo.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity(name = "Course")
@Table(name="Course")
public class Course {

    @Id
    @NotNull
    private String c_id;

    @Column(name = "c_name", nullable=false)
    private String c_name;

    @Column(name = "t_name", nullable=false)
    private String t_name;







    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }


}
