package com.tbutler78.minemapping.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="county")
public class County {
    @Id
    private int id;
    private String name;

    public County() {

    }

    public County(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "County{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        County county = (County) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(name, county.name)
                .isEquals();

    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder(17, 37).
                append(name).
                append(id).
                toHashCode();
    }
}

