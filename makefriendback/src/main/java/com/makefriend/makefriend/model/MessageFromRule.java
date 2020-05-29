package com.makefriend.makefriend.model;

public class MessageFromRule {
    private String text;
    private float strength;

    public MessageFromRule(String text, float strength) {
        this.text = text;
        this.strength = strength;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }
}
