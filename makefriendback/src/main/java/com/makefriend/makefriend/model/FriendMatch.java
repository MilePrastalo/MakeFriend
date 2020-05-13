package com.makefriend.makefriend.model;

import java.util.List;

public class FriendMatch {
    private List<String> userAInterests;
    private List<String> userATraits;

    private List<CategoryLike> alikesCategories;

    private List<String> userBInterests;
    private List<String> userBTraits;

    private List<CategoryLike> blikesCategories;


    private int similar;
    private boolean matchTraits;
    private int checkedTraits;

    public FriendMatch() {
    }

    public FriendMatch(List<String> userAInterests, List<String> userATraits, List<CategoryLike> alikesCategories, List<String> userBInterests, List<String> userBTraits, List<CategoryLike> blikesCategories, int similar, boolean matchTraits, int checkedTraits) {
        this.userAInterests = userAInterests;
        this.userATraits = userATraits;
        this.alikesCategories = alikesCategories;
        this.userBInterests = userBInterests;
        this.userBTraits = userBTraits;
        this.blikesCategories = blikesCategories;
        this.similar = similar;
        this.matchTraits = matchTraits;
        this.checkedTraits = checkedTraits;
    }

    public List<String> getUserAInterests() {
        return userAInterests;
    }

    public void setUserAInterests(List<String> userAInterests) {
        this.userAInterests = userAInterests;
    }

    public List<String> getUserATraits() {
        return userATraits;
    }

    public void setUserATraits(List<String> userATraits) {
        this.userATraits = userATraits;
    }

    public List<CategoryLike> getAlikesCategories() {
        return alikesCategories;
    }

    public void setAlikesCategories(List<CategoryLike> alikesCategories) {
        this.alikesCategories = alikesCategories;
    }

    public List<String> getUserBInterests() {
        return userBInterests;
    }

    public void setUserBInterests(List<String> userBInterests) {
        this.userBInterests = userBInterests;
    }

    public List<String> getUserBTraits() {
        return userBTraits;
    }

    public void setUserBTraits(List<String> userBTraits) {
        this.userBTraits = userBTraits;
    }

    public List<CategoryLike> getBlikesCategories() {
        return blikesCategories;
    }

    public void setBlikesCategories(List<CategoryLike> blikesCategories) {
        this.blikesCategories = blikesCategories;
    }

    public int getSimilar() {
        return similar;
    }

    public void setSimilar(int similar) {
        this.similar = similar;
    }

    public boolean isMatchTraits() {
        return matchTraits;
    }

    public void setMatchTraits(boolean matchTraits) {
        this.matchTraits = matchTraits;
    }

    public int getCheckedTraits() {
        return checkedTraits;
    }

    public void setCheckedTraits(int checkedTraits) {
        this.checkedTraits = checkedTraits;
    }

    public boolean getCategoryValue(int user, String name){
        if(user == 1){
            return this.alikesCategories.stream().filter(categoryLike -> categoryLike.getCategoryName().equals(name)).findFirst().get().getLikes();
        }
        return this.blikesCategories.stream().filter(categoryLike -> categoryLike.getCategoryName().equals(name)).findFirst().get().getLikes();
    }
    public void likeCategory(int user, String name){
        if(user==1){
            alikesCategories.stream().filter(categoryLike -> categoryLike.getCategoryName().equals(name)).findFirst().get().setLikes(true);
        }else{
            blikesCategories.stream().filter(categoryLike -> categoryLike.getCategoryName().equals(name)).findFirst().get().setLikes(true);
        }
    }
}
