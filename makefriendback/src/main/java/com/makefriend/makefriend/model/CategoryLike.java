package com.makefriend.makefriend.model;

public class CategoryLike {
    private String categoryName;
    private Boolean likes;

    public CategoryLike() {
    }

    public CategoryLike(String categoryName, Boolean likes) {
        this.categoryName = categoryName;
        this.likes = likes;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getLikes() {
        return likes;
    }

    public void setLikes(Boolean likes) {
        this.likes = likes;
    }
}
