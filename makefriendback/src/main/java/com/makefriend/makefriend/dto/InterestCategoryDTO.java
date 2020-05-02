package com.makefriend.makefriend.dto;

import com.makefriend.makefriend.model.InterestCategory;

import java.util.List;
import java.util.stream.Collectors;

public class InterestCategoryDTO {
    private Long id;
    private String name;
    private List<InterestDTO> interests;

    public InterestCategoryDTO() {
    }

    public InterestCategoryDTO(InterestCategory interestCategory) {
        this.id = interestCategory.getId();
        this.name = interestCategory.getName();
        this.interests = interestCategory.getInterests().stream().map(interest -> new InterestDTO(interest)).collect(Collectors.toList());
    }
}
