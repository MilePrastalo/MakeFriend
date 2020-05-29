package com.makefriend.makefriend.dto;

import com.makefriend.makefriend.model.UserTrait;

public class UserTraitDTO {
    private Long id;
    private String name;
    private Boolean value;

    public UserTraitDTO() {
    }

    public UserTraitDTO(UserTrait trait) {
        this.id = trait.getTrait().getId();
        this.name = trait.getTrait().getName();
        this.value = trait.isValue();
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

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
