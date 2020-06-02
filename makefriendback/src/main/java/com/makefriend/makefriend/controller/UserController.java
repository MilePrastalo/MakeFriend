package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.dto.*;
import com.makefriend.makefriend.model.Interest;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.model.UserTrait;
import com.makefriend.makefriend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @GetMapping(value = "")
    public ResponseEntity<ProfileDetailsDTO> getProfileDetails() {
        String username = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            username = authentication.getName();
        } else {
            return null;
        }
        User user = userService.findOneByUsename(username);
        ProfileDetailsDTO dto = new ProfileDetailsDTO(user);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileDetailsDTO> setProfileDetails(@RequestBody ProfileDetailsDTO profileDetailsDTO) {
        String username = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            username = authentication.getName();
        } else {
            return null;
        }
        User user = userService.setUserDetails(username, profileDetailsDTO);
        return new ResponseEntity<>(new ProfileDetailsDTO(user), HttpStatus.OK);
    }

    @GetMapping(value = "interests")
    public ResponseEntity<List<InterestDTO>> getUserInterests() {
        String username = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            username = authentication.getName();
        } else {
            return null;
        }
        List<Interest> interests = userService.getInterests(username);
        List<InterestDTO> interestDTOS = interests.stream().map(InterestDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(interestDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "interests", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileDetailsDTO> setUserInterests(@RequestBody List<InterestDTO> dto) {
        String username = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            username = authentication.getName();
        } else {
            return null;
        }
        User user = userService.setInterests(username, dto);
        ProfileDetailsDTO profileDetailsDTO = new ProfileDetailsDTO(user);
        return new ResponseEntity<>(profileDetailsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "traits")
    public ResponseEntity<List<UserTraitDTO>> getTraits() {
        String username = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            username = authentication.getName();
        } else {
            return null;
        }
        List<UserTrait> traits = userService.getTraits(username);
        List<UserTraitDTO> dtoTraits = traits.stream().map(UserTraitDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(dtoTraits, HttpStatus.OK);
    }

    @PostMapping(value = "traits", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileDetailsDTO> setTraits(@RequestBody List<UserTraitDTO> traitsDTO) {
        String username = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            username = authentication.getName();
        } else {
            return null;
        }
        User user = userService.setTraits(username, traitsDTO);
        ProfileDetailsDTO dto = new ProfileDetailsDTO(user);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
