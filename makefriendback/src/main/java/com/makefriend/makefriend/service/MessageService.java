package com.makefriend.makefriend.service;

import com.makefriend.makefriend.dto.MessageDTO;
import com.makefriend.makefriend.model.Message;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    private UserService userService;

    public MessageService(MessageRepository messageRepository, UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    public List<User> getFriendsChat(Long userId) {
        List<User> friends = userService.findFriends(userId);
        return friends;
    }

    public List<Message> findChatMessages(Long userId, Long friendId) {
        return messageRepository.findChatMessages(userId, friendId);
    }
    public Message sendMessage(MessageDTO dto) throws ParseException {
        User sender = userService.findOne(dto.getSender());
        User receiver = userService.findOne(dto.getReceiver());
        Message m = new Message();
        m.setReceiver(receiver);
        m.setSender(sender);
        m.setText(dto.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        m.setTime(sdf.parse(dto.getTime()));
        return messageRepository.save(m);
    }

}
