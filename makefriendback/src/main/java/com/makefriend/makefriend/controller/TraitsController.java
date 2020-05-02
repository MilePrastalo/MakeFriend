package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.dto.InterestCategoryDTO;
import com.makefriend.makefriend.dto.InterestsDTO;
import com.makefriend.makefriend.dto.TraitDTO;
import com.makefriend.makefriend.dto.TraitsDTO;
import com.makefriend.makefriend.model.InterestCategory;
import com.makefriend.makefriend.model.Trait;
import com.makefriend.makefriend.service.InterestCategoryService;
import com.makefriend.makefriend.service.InterestService;
import com.makefriend.makefriend.service.TraitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TraitsController {
    private final InterestCategoryService interestCategoryService;
    private final InterestService interestService;
    private final TraitService traitService;

    public TraitsController(InterestCategoryService interestCategoryService, InterestService interestService, TraitService traitService) {
        this.interestCategoryService = interestCategoryService;
        this.interestService = interestService;
        this.traitService = traitService;
    }

    @GetMapping("api/traits")
    public ResponseEntity<TraitsDTO> getAllTraits() {
        List<Trait> traits = traitService.findAll();
        List<TraitDTO> traitsDTOList = traits.stream().map(TraitDTO::new).collect(Collectors.toList());
        TraitsDTO traitsDTO = new TraitsDTO();
        traitsDTO.setTraits(traitsDTOList);
        return new ResponseEntity<>(traitsDTO, HttpStatus.OK);
    }

    @PostMapping("api/traits")
    public void addTrait() {
        //TODO
    }

    @GetMapping("api/interests")
    public ResponseEntity<InterestsDTO> getAllInterests() {
        List<InterestCategory> interests = interestCategoryService.findAll();
        List<InterestCategoryDTO> interestcategorydto = interests.stream().map(InterestCategoryDTO::new).collect(Collectors.toList());
        InterestsDTO interestsDTO = new InterestsDTO(interestcategorydto);
        return new ResponseEntity<>(interestsDTO, HttpStatus.OK);
    }

    @PostMapping("api/interests")
    public void addInterest() {
        //TODO
    }
}
