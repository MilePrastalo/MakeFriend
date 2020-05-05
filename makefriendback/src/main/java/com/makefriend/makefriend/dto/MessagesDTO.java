package com.makefriend.makefriend.dto;

import java.util.List;

public class MessagesDTO {
    private List<MessageDTO> messages;

    public MessagesDTO() {
    }

    public MessagesDTO(List<MessageDTO> messages) {
        this.messages = messages;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }
}
