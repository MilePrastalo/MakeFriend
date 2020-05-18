package com.makefriend.makefriend.model;

import java.util.ArrayList;
import java.util.List;

public class MessageSuggest {
    private List<String> userAInterests;
    private List<String> userBInterests;
    private List<String> categoriesALiked;
    private List<String> categoriesBLiked;
    private List<String> existCombination;
    private List<MessageFromRule> messageSuggests;
    private List<String> commonCategories;

    public MessageSuggest(List<String> userAInterests, List<String> userBInterests, List<String> categoriesALiked, List<String> categoriesBLiked, List<String> existCombination, List<MessageFromRule> messageSuggests, List<String> commonCategories) {
        this.userAInterests = userAInterests;
        this.userBInterests = userBInterests;
        this.categoriesALiked = categoriesALiked;
        this.categoriesBLiked = categoriesBLiked;
        this.existCombination = existCombination;
        this.messageSuggests = messageSuggests;
        this.commonCategories = commonCategories;
    }

    public MessageSuggest() {
        categoriesALiked = new ArrayList<>();
        categoriesBLiked = new ArrayList<>();
        commonCategories = new ArrayList<>();
        messageSuggests = new ArrayList<>();
        existCombination = new ArrayList<>();
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

    public List<String> getCategoriesALiked() {
        return categoriesALiked;
    }

    public void setCategoriesALiked(List<String> categoriesALiked) {
        this.categoriesALiked = categoriesALiked;
    }

    public List<String> getCategoriesBLiked() {
        return categoriesBLiked;
    }

    public void setCategoriesBLiked(List<String> categoriesBLiked) {
        this.categoriesBLiked = categoriesBLiked;
    }

    public List<String> getExistCombination() {
        return existCombination;
    }

    public void setExistCombination(List<String> existCombination) {
        this.existCombination = existCombination;
    }

    public List<MessageFromRule> getMessageSuggests() {
        return messageSuggests;
    }

    public void setMessageSuggests(List<MessageFromRule> messageSuggests) {
        this.messageSuggests = messageSuggests;
    }


    public List<String> getCommonCategories() {
        return commonCategories;
    }

    public void setCommonCategories(List<String> commonCategories) {
        this.commonCategories = commonCategories;
    }

}
