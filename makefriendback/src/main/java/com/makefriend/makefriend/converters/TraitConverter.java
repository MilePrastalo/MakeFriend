package com.makefriend.makefriend.converters;

import com.makefriend.makefriend.dto.TraitDTO;
import com.makefriend.makefriend.model.Trait;

public class TraitConverter {

    public static Trait fromDTO(TraitDTO dto) {
        Trait t = new Trait();
        t.setId(dto.getId());
        t.setName(dto.getName());
        return t;
    }
}
