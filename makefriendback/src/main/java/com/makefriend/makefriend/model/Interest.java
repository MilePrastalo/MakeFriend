package com.makefriend.makefriend.model;

import javax.persistence.*;

@Entity
public class Interest {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @ManyToOne
    private InterestCategory category;

    public Interest() {
    }

    public Interest(String name) {
        this.name = name;
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

    public InterestCategory getCategory() {
        return category;
    }

    public void setCategory(InterestCategory category) {
        this.category = category;
    }
}
