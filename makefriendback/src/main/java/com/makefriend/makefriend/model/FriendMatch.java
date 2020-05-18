package com.makefriend.makefriend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FriendMatch {
    private List<String> userAInterests;
    private List<UserTrait> userATraits;

    private List<String> alikesCategories;

    private List<String> userBInterests;
    private List<UserTrait> userBTraits;

    private List<String> blikesCategories;

    private List<String> processed;

    private List<String> possitiveATraits;
    private List<String> negativeATraits;

    private List<String> possitiveBTraits;
    private List<String> negativeBTraits;


    private int similar;
    private boolean matchTraits;
    private int similarTraits;

    public FriendMatch() {
        this.alikesCategories = new ArrayList<>();
        this.blikesCategories = new ArrayList<>();
        this.processed = new ArrayList<>();
        this.possitiveATraits = new ArrayList<>();
        this.negativeATraits = new ArrayList<>();
        this.possitiveBTraits = new ArrayList<>();
        this.negativeBTraits = new ArrayList<>();
    }


    public FriendMatch(List<String> userAInterests, List<UserTrait> userATraits, List<String> alikesCategories, List<String> userBInterests, List<UserTrait> userBTraits, List<String> blikesCategories, int similar, boolean matchTraits) {
        this.userAInterests = userAInterests;
        this.userATraits = userATraits;
        this.alikesCategories = alikesCategories;
        this.userBInterests = userBInterests;
        this.userBTraits = userBTraits;
        this.blikesCategories = blikesCategories;
        this.similar = similar;
        this.matchTraits = matchTraits;

    }

    public FriendMatch(User u1, User u2) {

        this.userAInterests = u1.getInterests().stream().map(Interest::getName).collect(Collectors.toList());
        this.userBInterests = u2.getInterests().stream().map(Interest::getName).collect(Collectors.toList());

        this.possitiveATraits = u1.getTraits().stream().filter(UserTrait::isValue).map(userTrait -> userTrait.getTrait().getName()).collect(Collectors.toList());
        this.negativeATraits = u1.getTraits().stream().filter(userTrait -> !userTrait.isValue()).map(userTrait -> userTrait.getTrait().getName()).collect(Collectors.toList());
        this.possitiveBTraits = u2.getTraits().stream().filter(UserTrait::isValue).map(userTrait -> userTrait.getTrait().getName()).collect(Collectors.toList());
        this.negativeBTraits = u2.getTraits().stream().filter(userTrait -> !userTrait.isValue()).map(userTrait -> userTrait.getTrait().getName()).collect(Collectors.toList());


        this.alikesCategories = new ArrayList<>();
        this.blikesCategories = new ArrayList<>();
        this.processed = new ArrayList<>();

        similar = 0;
        matchTraits = false;
        similarTraits = 0;

    }

    public List<String> getUserAInterests() {
        return userAInterests;
    }

    public void setUserAInterests(List<String> userAInterests) {
        this.userAInterests = userAInterests;
    }

    public List<UserTrait> getUserATraits() {
        return userATraits;
    }

    public void setUserATraits(List<UserTrait> userATraits) {
        this.userATraits = userATraits;
    }

    public List<String> getAlikesCategories() {
        return alikesCategories;
    }

    public void setAlikesCategories(List<String> alikesCategories) {
        this.alikesCategories = alikesCategories;
    }

    public List<String> getUserBInterests() {
        return userBInterests;
    }

    public void setUserBInterests(List<String> userBInterests) {
        this.userBInterests = userBInterests;
    }

    public List<UserTrait> getUserBTraits() {
        return userBTraits;
    }

    public void setUserBTraits(List<UserTrait> userBTraits) {
        this.userBTraits = userBTraits;
    }

    public List<String> getBlikesCategories() {
        return blikesCategories;
    }

    public void setBlikesCategories(List<String> blikesCategories) {
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

    public int getSimilarTraits() {
        return similarTraits;
    }

    public void setSimilarTraits(int similarTraits) {
        this.similarTraits = similarTraits;
    }

    public List<String> getProcessed() {
        return processed;
    }

    public void setProcessed(List<String> processed) {
        this.processed = processed;
    }

    public List<String> getPossitiveATraits() {
        return possitiveATraits;
    }

    public void setPossitiveATraits(List<String> possitiveATraits) {
        this.possitiveATraits = possitiveATraits;
    }

    public List<String> getNegativeATraits() {
        return negativeATraits;
    }

    public void setNegativeATraits(List<String> negativeATraits) {
        this.negativeATraits = negativeATraits;
    }

    public List<String> getPossitiveBTraits() {
        return possitiveBTraits;
    }

    public void setPossitiveBTraits(List<String> possitiveBTraits) {
        this.possitiveBTraits = possitiveBTraits;
    }

    public List<String> getNegativeBTraits() {
        return negativeBTraits;
    }

    public void setNegativeBTraits(List<String> negativeBTraits) {
        this.negativeBTraits = negativeBTraits;
    }
}
