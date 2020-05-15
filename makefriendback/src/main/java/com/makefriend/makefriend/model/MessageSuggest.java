package com.makefriend.makefriend.model;

import java.util.List;

public class MessageSuggest {
    private List<String> userAInterests;
    private List<String> userBInterests;
    private List<CategoryLike> categoriesLiked;
    private List<String> existCombination;

    public MessageSuggest(List<String> userAInterests, List<String> userBInterests, List<CategoryLike> categoriesLiked, List<String> existCombination) {
        this.userAInterests = userAInterests;
        this.userBInterests = userBInterests;
        this.categoriesLiked = categoriesLiked;
        this.existCombination = existCombination;
    }

    public MessageSuggest() {
    }

    public List<String> getUserAInterests() {
        return userAInterests;
    }

    public void setUserAInterests(List<String> userAInterests) {
        this.userAInterests = userAInterests;
    }

    public List<String> getUserBInterests() {
        return userBInterests;
    }

    public void setUserBInterests(List<String> userBInterests) {
        this.userBInterests = userBInterests;
    }

    public List<CategoryLike> getCategoriesLiked() {
        return categoriesLiked;
    }

    public void setCategoriesLiked(List<CategoryLike> categoriesLiked) {
        this.categoriesLiked = categoriesLiked;
    }

    public List<String> getExistCombination() {
        return existCombination;
    }

    public void setExistCombination(List<String> existCombination) {
        this.existCombination = existCombination;
    }
}
