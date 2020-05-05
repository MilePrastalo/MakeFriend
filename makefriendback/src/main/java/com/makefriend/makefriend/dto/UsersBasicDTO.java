package com.makefriend.makefriend.dto;

import java.util.List;

public class UsersBasicDTO {
    private List<UserBasicDto> users;

    public UsersBasicDTO(List<UserBasicDto> users) {
        this.users = users;
    }

    public UsersBasicDTO() {
    }

    public List<UserBasicDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserBasicDto> users) {
        this.users = users;
    }
}
