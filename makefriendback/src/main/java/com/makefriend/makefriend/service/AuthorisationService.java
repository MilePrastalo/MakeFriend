package com.makefriend.makefriend.service;

import com.makefriend.makefriend.dto.LoginDTO;
import com.makefriend.makefriend.dto.RegistrationDTO;
import com.makefriend.makefriend.model.Authority;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.repository.AuthorityRepository;
import com.makefriend.makefriend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorisationService {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    public AuthorisationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean login(LoginDTO dto) {
        User user = userRepository.findByUsername(dto.getUsername());
        return true;
    }

    public Boolean register(RegistrationDTO dto) {
        Authority auth = authorityRepository.findByName("USER");
        ArrayList<Authority> authorities = new ArrayList<>();
        authorities.add(auth);
        User user = new User(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(), dto.getEmail(), authorities);
        userRepository.save(user);
        return true;
    }
}
