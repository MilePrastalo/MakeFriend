package com.makefriend.makefriend.dto;

public class MessageHeadDTO {
    private String name;
    private String imagePath;
    private String lastText;
    private String username;

    public MessageHeadDTO() {
    }

    public MessageHeadDTO(String name, String imagePath, String lastText, String username) {
        this.name = name;
        this.imagePath = imagePath;
        this.lastText = lastText;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getLastText() {
        return lastText;
    }

    public void setLastText(String lastText) {
        this.lastText = lastText;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
