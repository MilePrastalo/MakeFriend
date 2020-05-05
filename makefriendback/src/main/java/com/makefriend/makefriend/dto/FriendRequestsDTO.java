package com.makefriend.makefriend.dto;

import java.util.List;

public class FriendRequestsDTO {
    private List<FriendRequestDTO> requests;

    public FriendRequestsDTO(List<FriendRequestDTO> requests) {
        this.requests = requests;
    }

    public FriendRequestsDTO() {
    }

    public List<FriendRequestDTO> getRequests() {
        return requests;
    }

    public void setRequests(List<FriendRequestDTO> requests) {
        this.requests = requests;
    }
}
