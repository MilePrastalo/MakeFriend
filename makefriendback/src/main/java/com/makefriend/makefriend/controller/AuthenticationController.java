package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.dto.LoginDTO;
import com.makefriend.makefriend.dto.RegistrationDTO;
import com.makefriend.makefriend.service.AuthorisationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class AuthenticationController {

    private final AuthorisationService authorisationService;

    public AuthenticationController(AuthorisationService authorisationService) {
        this.authorisationService = authorisationService;
    }

    @PostMapping("login")
    public ResponseEntity<Boolean> login(@RequestBody LoginDTO dto) {
        Boolean response = authorisationService.login(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<Boolean> register(@RequestBody  RegistrationDTO dto) {
        Boolean response = authorisationService.register(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
