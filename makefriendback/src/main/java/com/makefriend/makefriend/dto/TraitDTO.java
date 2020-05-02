package com.makefriend.makefriend.dto;

import com.makefriend.makefriend.model.Trait;

public class TraitDTO {
    private Long id;
    private String name;

    public TraitDTO() {
    }

    public TraitDTO(Trait trait) {
        this.id = trait.getId();
        this.name = trait.getName();
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
}
