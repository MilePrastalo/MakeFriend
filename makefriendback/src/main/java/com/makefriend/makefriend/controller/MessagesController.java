package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.converters.MessageConverter;
import com.makefriend.makefriend.dto.MessageDTO;
import com.makefriend.makefriend.dto.MessageHeadDTO;
import com.makefriend.makefriend.model.*;
import com.makefriend.makefriend.service.MessageService;
import com.makefriend.makefriend.service.UserService;
import org.kie.api.runtime.KieContainer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/messages", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessagesController {

    private final MessageService messageService;
    private UserService userService;

    public MessagesController(MessageService messageService, KieContainer kieContainer, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<MessageHeadDTO>> getMessages() {
        List<User> friends = messageService.getFriendsChat();
        List<MessageHeadDTO> list = friends.stream().map(user -> new MessageHeadDTO(user.getFirstName() + " " + user.getLastName(), "", "", user.getUsername())).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{friendUsername}")
    public ResponseEntity<List<MessageDTO>> getChatMessages(@PathVariable("friendUsername") String friendUsername) {
        List<Message> messages = this.messageService.findChatMessages(friendUsername);
        List<MessageDTO> messagesDto = messages.stream().map(MessageConverter::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(messagesDto, HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageDTO> sendChatMessage(@RequestBody MessageDTO dto) throws ParseException {
        Message m = messageService.sendMessage(dto);
        return new ResponseEntity<>(MessageConverter.toDTO(m), HttpStatus.OK);
    }

    @GetMapping("suggested/{friendUsername}")
    public ResponseEntity<MessageFromRule> getSuggestedMessage(@PathVariable("friendUsername") String friendUsername) {
        MessageSuggest ms = messageService.getSuggestedMessage(friendUsername);
        //Sort messages
        for (int i = 0; i<ms.getMessageSuggests().size()-1; i++) {
            for (int j = i+1; j<ms.getMessageSuggests().size(); j++) {
                if(ms.getMessageSuggests().get(j).getStrength()>ms.getMessageSuggests().get(i).getStrength()){
                    MessageFromRule temp = ms.getMessageSuggests().get(j);
                    ms.getMessageSuggests().set(j,ms.getMessageSuggests().get(i));
                    ms.getMessageSuggests().set(i,temp);
                }
            }
        }
        if(ms.getMessageSuggests().size() == 0){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(ms.getMessageSuggests().get(0), HttpStatus.OK);
    }


}
