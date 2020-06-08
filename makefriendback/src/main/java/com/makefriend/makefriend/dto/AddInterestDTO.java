package com.makefriend.makefriend.dto;

public class AddInterestDTO {
    private Long categoryId;
    private String name;

    public AddInterestDTO() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
