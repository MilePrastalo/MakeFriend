package com.makefriend.makefriend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/profile", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @GetMapping("{userId}")
    public void getProfileDetails() {

    }

    @PostMapping("{userId}")
    public void setProfileDetails() {

    }

    @GetMapping("{userId}/interests")
    public void getUserInterests() {

    }

    @PostMapping("{userId}/interests")
    public void setUserInterests() {

    }

    @GetMapping("{userId}/traits")
    public void getTraits() {

    }

    @PostMapping("{userId}/traits")
    public void setTraits() {

    }
}
