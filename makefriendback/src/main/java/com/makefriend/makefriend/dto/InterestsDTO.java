package com.makefriend.makefriend.dto;

import java.util.List;

public class InterestsDTO {
    List<InterestCategoryDTO> interests;

    public InterestsDTO() {
    }

    public InterestsDTO(List<InterestCategoryDTO> interests) {
        this.interests = interests;
    }

    public List<InterestCategoryDTO> getInterests() {
        return interests;
    }

    public void setInterests(List<InterestCategoryDTO> interests) {
        this.interests = interests;
    }
}
