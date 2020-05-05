package com.makefriend.makefriend.dto;

import com.makefriend.makefriend.model.FriendRequest;

public class FriendRequestDTO {
    private Long id;
    private Long sender;
    private Long receiver;

    public FriendRequestDTO(Long id, Long sender, Long receiver) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
    }

    public FriendRequestDTO(FriendRequest request) {
        this.id = request.getId();
        this.sender = request.getSender().getId();
        this.receiver = request.getReceiver().getId();
    }

    public FriendRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }
}
