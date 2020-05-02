package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.dto.MessageHead;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/messages", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessagesController {

    @GetMapping("{userId}")
    public ResponseEntity<MessageHead> getMessages(){
        //TODO
        return null;
    }

    @GetMapping("{userId}/{friendID}")
    public void getChatMessages(){

    }

    @PostMapping("{userId}/{friendId}")
    public void sendChatMessage(){

    }

    @GetMapping("suggested/{userId}/{friendId}")
    public void getSuggestedMessage(){

    }


}
