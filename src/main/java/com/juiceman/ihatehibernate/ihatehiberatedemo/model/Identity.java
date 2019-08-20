package com.juiceman.ihatehibernate.ihatehiberatedemo.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Identity implements Serializable {

    private String firstname;

    private String lastname;


    public Identity(){
        super();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        final Identity identity = (Identity) o;

        if ( !firstname.equals( identity.firstname ) ) return false;
        if ( !lastname.equals( identity.lastname ) ) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = firstname.hashCode();
        result = 29 * result + lastname.hashCode();
        return result;
    }
}