package com.makefriend.makefriend.dto;

import java.util.List;

public class TraitsDTO {
    private List<TraitDTO> traits;

    public TraitsDTO() {
    }

    public TraitsDTO(List<TraitDTO> traits) {
        this.traits = traits;
    }

    public List<TraitDTO> getTraits() {
        return traits;
    }

    public void setTraits(List<TraitDTO> traits) {
        this.traits = traits;
    }
}
