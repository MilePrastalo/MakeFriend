package com.makefriend.makefriend.model;

public class MessageFromRule {
    private String text;
    private float strenght;

    public MessageFromRule(String text, float strenght) {
        this.text = text;
        this.strenght = strenght;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getStrenght() {
        return strenght;
    }

    public void setStrenght(float strenght) {
        this.strenght = strenght;
    }
}
