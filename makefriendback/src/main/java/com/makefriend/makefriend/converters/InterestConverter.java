package com.makefriend.makefriend.converters;

import com.makefriend.makefriend.dto.InterestDTO;
import com.makefriend.makefriend.model.Interest;

public class InterestConverter {

    public static Interest fromDTO(InterestDTO dto) {
        Interest i = new Interest();
        i.setId(dto.getId());
        i.setName(dto.getName());
        return i;
    }
}
