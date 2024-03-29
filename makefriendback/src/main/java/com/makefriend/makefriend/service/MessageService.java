package com.makefriend.makefriend.service;

import com.makefriend.makefriend.dto.MessageDTO;
import com.makefriend.makefriend.model.Message;
import com.makefriend.makefriend.model.MessageFromRule;
import com.makefriend.makefriend.model.MessageSuggest;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.repository.MessageRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    private UserService userService;
    private KieContainer kieContainer;

    public MessageService(MessageRepository messageRepository, UserService userService, KieContainer kieContainer) {
        this.messageRepository = messageRepository;
        this.userService = userService;
        this.kieContainer = kieContainer;
    }

    public List<User> getFriendsChat() {
        User user = userService.getUserFromAuthentication();
        List<User> friends = userService.findFriends(user.getId());
        return friends;
    }

    public List<Message> findChatMessages(String friendUsername) {
        User user = userService.getUserFromAuthentication();
        return messageRepository.findChatMessages(user.getUsername(), friendUsername);
    }
    public Message sendMessage(MessageDTO dto) throws ParseException {
        User sender = userService.findOneByUsename(dto.getSender());
        User receiver = userService.findOneByUsename(dto.getReceiver());
        Message m = new Message();
        m.setReceiver(receiver);
        m.setSender(sender);
        m.setText(dto.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        m.setTime(sdf.parse(dto.getTime()));
        return messageRepository.save(m);
    }

    public MessageSuggest getSuggestedMessage(String friendUsername){
        User u1 = userService.getUserFromAuthentication();
        User u2 = userService.findOneByUsename(friendUsername);
        MessageSuggest ms = new MessageSuggest(u1,u2);
        KieSession session = kieContainer.newKieSession("session");
        session.insert(ms);
        session.getAgenda().getAgendaGroup("Message").setFocus();
        session.fireAllRules();
        session.dispose();
        for (MessageFromRule m:ms.getMessageSuggests()) {
            System.out.println(m.getText()+"   " + m.getStrength());
        }
        return ms;
    }

}
