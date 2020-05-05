package com.makefriend.makefriend.dto;

import com.makefriend.makefriend.dto.MessageHeadDTO;

import java.util.List;

public class MessageHeadListDTO {
    private List<MessageHeadDTO> messages;

    public MessageHeadListDTO() {
    }

    public MessageHeadListDTO(List<MessageHeadDTO> messages) {
        this.messages = messages;
    }

    public List<MessageHeadDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageHeadDTO> messages) {
        this.messages = messages;
    }
}
