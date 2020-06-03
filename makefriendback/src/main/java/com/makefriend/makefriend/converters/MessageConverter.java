package com.makefriend.makefriend.converters;

import com.makefriend.makefriend.dto.MessageDTO;
import com.makefriend.makefriend.model.Message;

import java.text.SimpleDateFormat;

public class MessageConverter {

    public static MessageDTO toDTO(Message m) {
        MessageDTO dto = new MessageDTO();
        dto.setId(m.getId());
        dto.setReceiver(m.getReceiver().getUsername());
        dto.setSender(m.getSender().getUsername());
        dto.setText(m.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dto.setTime(sdf.format(m.getTime()));
        return dto;
    }
}
