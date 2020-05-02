package com.makefriend.makefriend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class InterestCategory {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @OneToMany
    private Set<Interest> interests;

    public InterestCategory(String name, Set<Interest> interests) {
        this.name = name;
        this.interests = interests;
    }

    public InterestCategory() {
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

    public Set<Interest> getInterests() {
        return interests;
    }

    public void setInterests(Set<Interest> interests) {
        this.interests = interests;
    }
}
