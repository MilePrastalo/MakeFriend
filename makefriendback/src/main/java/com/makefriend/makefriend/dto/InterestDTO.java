package com.makefriend.makefriend.dto;

import com.makefriend.makefriend.model.Interest;

public class InterestDTO {
    private Long id;
    private String name;

    public InterestDTO() {
    }

    public InterestDTO(Interest interest) {
        this.id = interest.getId();
        this.name = interest.getName();
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
