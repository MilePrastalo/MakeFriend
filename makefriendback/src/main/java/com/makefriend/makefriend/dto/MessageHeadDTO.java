package com.makefriend.makefriend.dto;

public class MessageHeadDTO {
    private String name;
    private String imagePath;
    private String lastText;

    public MessageHeadDTO() {
    }

    public MessageHeadDTO(String name, String imagePath, String lastText) {
        this.name = name;
        this.imagePath = imagePath;
        this.lastText = lastText;
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
}
