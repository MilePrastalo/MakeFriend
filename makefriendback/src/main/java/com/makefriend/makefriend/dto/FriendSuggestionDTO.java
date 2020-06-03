package com.makefriend.makefriend.dto;

public class FriendSuggestionDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int simmilar;
    private String username;

    public FriendSuggestionDTO(Long id, String firstName, String lastName, int simmilar,String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.simmilar = simmilar;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSimmilar() {
        return simmilar;
    }

    public void setSimmilar(int simmilar) {
        this.simmilar = simmilar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
