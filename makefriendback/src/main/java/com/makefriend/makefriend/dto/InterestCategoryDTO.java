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
        this.interests = interestCategory.getInterests().stream().map(InterestDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InterestDTO> getInterests() {
        return interests;
    }

    public void setInterests(List<InterestDTO> interests) {
        this.interests = interests;
    }
}
