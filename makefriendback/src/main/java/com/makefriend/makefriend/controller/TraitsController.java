package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.dto.InterestCategoryDTO;
import com.makefriend.makefriend.dto.TraitDTO;
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
    public ResponseEntity<List<TraitDTO>> getAllTraits() {
        List<Trait> traits = traitService.findAll();
        List<TraitDTO> traitsDTOList = traits.stream().map(TraitDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(traitsDTOList, HttpStatus.OK);
    }

    @PostMapping("api/traits")
    public void addTrait() {
        //TODO
    }

    @GetMapping("api/interests")
    public ResponseEntity<List<InterestCategoryDTO>> getAllInterests() {
        List<InterestCategory> interests = interestCategoryService.findAll();
        List<InterestCategoryDTO> interestcategorydto = interests.stream().map(InterestCategoryDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(interestcategorydto, HttpStatus.OK);
    }

    @PostMapping("api/interests")
    public void addInterest() {
        //TODO
    }
}
