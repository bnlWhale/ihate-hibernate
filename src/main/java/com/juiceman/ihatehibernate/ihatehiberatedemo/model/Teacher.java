package com.juiceman.ihatehibernate.ihatehiberatedemo.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Teacher")
@Table(name = "Teacher")
public class Teacher {

    @Id
    @NotNull
    @Size(max = 60)
    private String t_id;

    private String t_name;




    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }
}
