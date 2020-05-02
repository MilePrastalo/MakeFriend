package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.dto.*;
import com.makefriend.makefriend.model.Interest;
import com.makefriend.makefriend.model.Trait;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/profile", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "{userId}")
    public ResponseEntity<ProfileDetailsDTO> getProfileDetails(@PathVariable("userId") Long userId) {
        User user = userService.findOne(userId);
        ProfileDetailsDTO dto = new ProfileDetailsDTO(user);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(value = "{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileDetailsDTO> setProfileDetails(@PathVariable("userId") Long userId, @RequestBody ProfileDetailsDTO profileDetailsDTO) {
        User user = userService.setUserDetails(userId, profileDetailsDTO);
        return new ResponseEntity<>(new ProfileDetailsDTO(user), HttpStatus.OK);
    }

    @GetMapping(value = "{userId}/interests")
    public ResponseEntity<UserInterestsDTO> getUserInterests(@PathVariable("userId") Long userId) {
        List<Interest> interests = userService.getInterests(userId);
        List<InterestDTO> interestDTOS = interests.stream().map(InterestDTO::new).collect(Collectors.toList());
        UserInterestsDTO dto = new UserInterestsDTO(interestDTOS);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(value = "{userId}/interests", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileDetailsDTO> setUserInterests(@PathVariable("userId") Long userId, @RequestBody UserInterestsDTO dto) {
        User user = userService.setInterests(userId, dto);
        ProfileDetailsDTO profileDetailsDTO = new ProfileDetailsDTO(user);
        return new ResponseEntity<>(profileDetailsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "{userId}/traits")
    public ResponseEntity<TraitsDTO> getTraits(@PathVariable("userId") Long userId) {
        List<Trait> traits = userService.getTraits(userId);
        List<TraitDTO> dtoTraits = traits.stream().map(TraitDTO::new).collect(Collectors.toList());
        TraitsDTO dto = new TraitsDTO(dtoTraits);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(value = "{userId}/traits", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileDetailsDTO> setTraits(@PathVariable("userId") Long userId, @RequestBody TraitsDTO traitsDTO) {
        User user = userService.setTraits(userId, traitsDTO);
        ProfileDetailsDTO dto = new ProfileDetailsDTO(user);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
