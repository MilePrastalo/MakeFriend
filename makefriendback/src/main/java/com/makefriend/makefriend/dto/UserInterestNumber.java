package com.makefriend.makefriend.dto;

public class UserInterestNumber {
    private String username;
    private Long numberInterests;

    public UserInterestNumber() {
    }

    public UserInterestNumber(String username, Long numberInterests) {
        this.username = username;
        this.numberInterests = numberInterests;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getNumberInterests() {
        return numberInterests;
    }

    public void setNumberInterests(Long numberInterests) {
        this.numberInterests = numberInterests;
    }
}
