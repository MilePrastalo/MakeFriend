package com.makefriend.makefriend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("requests/{userId}")
    public void getFriendRequests(@PathVariable("userId") Long userId){

    }

}
