package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.converters.MessageConverter;
import com.makefriend.makefriend.dto.MessageDTO;
import com.makefriend.makefriend.dto.MessageHeadDTO;
import com.makefriend.makefriend.dto.MessageHeadListDTO;
import com.makefriend.makefriend.dto.MessagesDTO;
import com.makefriend.makefriend.model.*;
import com.makefriend.makefriend.service.MessageService;
import com.makefriend.makefriend.service.UserService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
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
    private KieContainer kieContainer;
    private UserService userService;

    public MessagesController(MessageService messageService, KieContainer kieContainer, UserService userService) {
        this.messageService = messageService;
        this.kieContainer = kieContainer;
        this.userService = userService;
    }

    @GetMapping("{userId}")
    public ResponseEntity<MessageHeadListDTO> getMessages(@PathVariable("userId") Long userId) {
        List<User> friends = messageService.getFriendsChat(userId);
        List<MessageHeadDTO> list = friends.stream().map(user -> new MessageHeadDTO(user.getFirstName() + " " + user.getLastName(), "", "")).collect(Collectors.toList());
        return new ResponseEntity<>(new MessageHeadListDTO(list), HttpStatus.OK);
    }

    @GetMapping("{userId}/{friendId}")
    public ResponseEntity<MessagesDTO> getChatMessages(@PathVariable("userId") Long userId, @PathVariable("friendId") Long friendId) {
        List<Message> messages = this.messageService.findChatMessages(userId, friendId);
        List<MessageDTO> messagesDto = messages.stream().map(MessageConverter::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(new MessagesDTO(messagesDto), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageDTO> sendChatMessage(@RequestBody MessageDTO dto) throws ParseException {
        Message m = messageService.sendMessage(dto);
        return new ResponseEntity<>(MessageConverter.toDTO(m), HttpStatus.OK);
    }

    @GetMapping("suggested/{userId}/{friendId}")
    public ResponseEntity<SuggestedMessages> getSuggestedMessage(@PathVariable("userId") Long userId, @PathVariable("friendId") Long friendId) {

        User u1 = userService.findOne(userId);
        User u2 = userService.findOne(friendId);
        MessageSuggest ms = new MessageSuggest(u1,u2);
        KieSession session = kieContainer.newKieSession("session");
        session.insert(ms);
        session.getAgenda().getAgendaGroup("Message").setFocus();
        session.fireAllRules();
        session.dispose();

        SuggestedMessages sm = new SuggestedMessages(ms.getMessageSuggests());
        return new ResponseEntity<>(sm, HttpStatus.OK);
    }


}
