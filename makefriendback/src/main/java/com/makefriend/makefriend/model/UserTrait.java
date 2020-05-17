package com.makefriend.makefriend.model;

import javax.persistence.*;

@Entity
public class UserTrait {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Trait trait;
    @Column
    private boolean value;

    public UserTrait() {
    }

    public UserTrait(Trait trait, boolean value) {
        this.trait = trait;
        this.value = value;
    }

    public Trait getTrait() {
        return trait;
    }

    public void setTrait(Trait trait) {
        this.trait = trait;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}

