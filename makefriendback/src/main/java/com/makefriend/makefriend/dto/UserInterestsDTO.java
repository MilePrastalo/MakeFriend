package com.makefriend.makefriend.dto;

import java.util.List;

public class UserInterestsDTO {
    private List<InterestDTO> interests;

    public UserInterestsDTO() {
    }

    public UserInterestsDTO(List<InterestDTO> interests) {
        this.interests = interests;
    }

    public List<InterestDTO> getInterests() {
        return interests;
    }

    public void setInterests(List<InterestDTO> interests) {
        this.interests = interests;
    }
}
