package com.tbutler78.minemapping.domain;


import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="county")
public class County {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

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

    @Override
    public String toString() {
        List<String> list =  ImmutableList.of("Test","test2");
        return "County{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

