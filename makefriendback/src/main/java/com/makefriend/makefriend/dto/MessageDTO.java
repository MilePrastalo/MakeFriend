package com.makefriend.makefriend.dto;

public class MessageDTO {

    private Long id;
    private Long sender;
    private Long receiver;
    private String time;
    private String text;

    public MessageDTO() {
    }

    public MessageDTO(Long id, Long sender, Long receiver, String time, String text) {
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

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
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
