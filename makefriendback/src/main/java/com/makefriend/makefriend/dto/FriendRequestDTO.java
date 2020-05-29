package com.makefriend.makefriend.dto;

import com.makefriend.makefriend.model.FriendRequest;

public class FriendRequestDTO {
    private Long id;
    private String sender;

    public FriendRequestDTO(Long id, String sender, Long receiver) {
        this.id = id;
        this.sender = sender;
    }

    public FriendRequestDTO(FriendRequest request) {
        this.id = request.getId();
        this.sender = request.getSender().getFirstName() + " " + request.getSender().getLastName();
    }

    public FriendRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
