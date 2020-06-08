package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.dto.AddInterestDTO;
import com.makefriend.makefriend.dto.AddTrait;
import com.makefriend.makefriend.dto.InterestCategoryDTO;
import com.makefriend.makefriend.dto.TraitDTO;
import com.makefriend.makefriend.model.InterestCategory;
import com.makefriend.makefriend.model.Trait;
import com.makefriend.makefriend.service.InterestCategoryService;
import com.makefriend.makefriend.service.InterestService;
import com.makefriend.makefriend.service.TraitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class TraitsController {
    private final InterestCategoryService interestCategoryService;
    private final InterestService interestService;
    private final TraitService traitService;

    public TraitsController(InterestCategoryService interestCategoryService, InterestService interestService, TraitService traitService) {
        this.interestCategoryService = interestCategoryService;
        this.interestService = interestService;
        this.traitService = traitService;
    }

    @GetMapping(value = "api/traits", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TraitDTO>> getAllTraits() {
        List<Trait> traits = traitService.findAll();
        List<TraitDTO> traitsDTOList = traits.stream().map(TraitDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(traitsDTOList, HttpStatus.OK);
    }

    @PostMapping(value = "api/traits", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TraitDTO>> addTrait(@RequestBody AddTrait addTrait) {
        List<Trait> traits = traitService.addTrait(addTrait);
        List<TraitDTO> traitsDTOList = traits.stream().map(TraitDTO::new).collect(Collectors.toList());
        return new ResponseEntity<List<TraitDTO>>(traitsDTOList, HttpStatus.OK);
    }

    @GetMapping("api/interests")
    public ResponseEntity<List<InterestCategoryDTO>> getAllInterests() {
        List<InterestCategory> interests = interestCategoryService.findAll();
        List<InterestCategoryDTO> interestcategorydto = interests.stream().map(InterestCategoryDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(interestcategorydto, HttpStatus.OK);
    }

    @PostMapping(value = "api/interests", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InterestCategoryDTO>> addInterest(@RequestBody AddInterestDTO interest) {
        List<InterestCategory> interests = interestService.addInterest(interest);
        List<InterestCategoryDTO> interestcategorydto = interests.stream().map(InterestCategoryDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(interestcategorydto, HttpStatus.OK);
    }
    @PostMapping(value = "api/interestsCategory",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InterestCategoryDTO>> addInterestCategory(@RequestBody AddTrait addCategory) {
        List<InterestCategory> interests = interestCategoryService.addCategory(addCategory);
        List<InterestCategoryDTO> interestcategorydto = interests.stream().map(InterestCategoryDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(interestcategorydto, HttpStatus.OK);
    }

    @DeleteMapping("api/traits/{traitId}")
    public ResponseEntity<List<TraitDTO>> deleteTrait(@PathVariable("traitId") Long traitId){
        List<Trait> traits = traitService.delete(traitId);
        List<TraitDTO> traitsDTOList = traits.stream().map(TraitDTO::new).collect(Collectors.toList());
        return new ResponseEntity<List<TraitDTO>>(traitsDTOList, HttpStatus.OK);
    }
}
