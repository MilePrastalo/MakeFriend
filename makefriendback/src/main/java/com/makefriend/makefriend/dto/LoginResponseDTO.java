package com.makefriend.makefriend.dto;

public class LoginResponseDTO {
    private Boolean ok;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(Boolean ok) {
        this.ok = ok;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }
}
