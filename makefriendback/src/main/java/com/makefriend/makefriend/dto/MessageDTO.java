package com.makefriend.makefriend.dto;

public class MessageDTO {

    private Long id;
    private String sender;
    private String receiver;
    private String time;
    private String text;

    public MessageDTO() {
    }

    public MessageDTO(Long id, String sender, String receiver, String time, String text) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.time = time;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
