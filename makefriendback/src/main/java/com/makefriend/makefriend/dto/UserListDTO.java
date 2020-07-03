package com.makefriend.makefriend.dto;

import com.makefriend.makefriend.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListDTO {
    private List<User> userList;

    public UserListDTO() {
        userList = new ArrayList<>();
    }

    public UserListDTO(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
