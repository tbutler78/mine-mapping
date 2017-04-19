package com.tbutler78.minemapping.domain;

import javax.persistence.*;

/**
 * Created by butlert on 4/12/17.
 */

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

}
