package com.makefriend.makefriend.model;

import java.util.List;

public class SuggestedMessages {
    private List<MessageFromRule> messages;

    public SuggestedMessages() {
    }

    public SuggestedMessages(List<MessageFromRule> messages) {
        this.messages = messages;
    }

    public List<MessageFromRule> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageFromRule> messages) {
        this.messages = messages;
    }
}
