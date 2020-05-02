package com.makefriend.makefriend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/friends", produces = MediaType.APPLICATION_JSON_VALUE)
public class FriendsController {

    @GetMapping("suggested/{userId}")
    public void getSuggestedFriend(){

    }
    @GetMapping("all/{userId}")
    public void getAllFriends(){

    }
    @PostMapping("")
    public void sendFriendRequest(){

    }
    @PostMapping("accept")
    public void acceptFriendRequest(){

    }
    @PostMapping("reject")
    public void rejectFriendRequest(){

    }

}
