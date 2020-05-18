package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.converters.MessageConverter;
import com.makefriend.makefriend.dto.MessageDTO;
import com.makefriend.makefriend.dto.MessageHeadDTO;
import com.makefriend.makefriend.dto.MessageHeadListDTO;
import com.makefriend.makefriend.dto.MessagesDTO;
import com.makefriend.makefriend.model.*;
import com.makefriend.makefriend.service.MessageService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/messages", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessagesController {

    private final MessageService messageService;
    private KieContainer kieContainer;

    public MessagesController(MessageService messageService, KieContainer kieContainer) {
        this.messageService = messageService;
        this.kieContainer = kieContainer;
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
        //Mock data
        User u1 = new User("pera01", "pass", "Petar", "Petrovic", "pera@pera.com", new ArrayList<>());
        User u2 = new User("mika", "pass", "Mika", "Mikic", "mika@pera.com", new ArrayList<>());
        u1.setId(1L);
        u2.setId(2L);
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        Interest i1 = new Interest("Football");
        Interest i2 = new Interest("Basketball");
        Interest i3 = new Interest("Volleyball");
        Interest i4 = new Interest("TV Shows");
        Interest i5 = new Interest("Movies");
        Interest i6 = new Interest("FantasyBooks");
        Interest i7 = new Interest("DramaBooks");
        Interest i8 = new Interest("PoetryBooks");
        Interest i9 = new Interest("DetectiveBooks");

        u1.getInterests().add(i1);
        u1.getInterests().add(i2);
        u1.getInterests().add(i3);
        u1.getInterests().add(i4);

        u2.getInterests().add(i1);
        u2.getInterests().add(i6);
        u2.getInterests().add(i7);
        u2.getInterests().add(i8);
        u2.getInterests().add(i9);


        //Example when user1 sends message to user2
        MessageSuggest ms = new MessageSuggest();
        ms.setUserAInterests(u1.getInterests().stream().map(Interest::getName).collect(Collectors.toList()));
        ms.setUserBInterests(u2.getInterests().stream().map(Interest::getName).collect(Collectors.toList()));
        ms.setUserBInterests(u2.getInterests().stream().map(Interest::getName).collect(Collectors.toList()));
        KieSession session = kieContainer.newKieSession("session");
        session.insert(ms);
        session.getAgenda().getAgendaGroup("Message").setFocus();
        session.fireAllRules();
        session.dispose();

        SuggestedMessages sm = new SuggestedMessages(ms.getMessageSuggests());
        return new ResponseEntity<>(sm, HttpStatus.OK);
    }


}
