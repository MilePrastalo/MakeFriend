package com.makefriend.makefriend.service;

import com.makefriend.makefriend.converters.TraitConverter;
import com.makefriend.makefriend.dto.InterestDTO;
import com.makefriend.makefriend.dto.ProfileDetailsDTO;
import com.makefriend.makefriend.dto.TraitsDTO;
import com.makefriend.makefriend.dto.UserInterestsDTO;
import com.makefriend.makefriend.model.Interest;
import com.makefriend.makefriend.model.Trait;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final InterestService interestService;

    public UserService(UserRepository userRepository, InterestService interestService) {
        this.userRepository = userRepository;
        this.interestService = interestService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User findOne(Long id) {
        return userRepository.findById(id).get();
    }

    public List<Interest> getInterests(Long userId) {
        User user = findOne(userId);
        return new ArrayList<>(user.getInterests());
    }

    public List<Trait> getTraits(Long userId) {
        User user = findOne(userId);
        return new ArrayList<>(user.getTraits());
    }

    public User setUserDetails(Long userId, ProfileDetailsDTO profileDetailsDTO) {
        User user = findOne(userId);
        user.setFirstName(profileDetailsDTO.getFirstName());
        user.setLastName(profileDetailsDTO.getLastName());
        user.setEmail(profileDetailsDTO.getEmail());
        return userRepository.save(user);
    }

    public User setTraits(Long userId, TraitsDTO traitsDTO) {
        User user = findOne(userId);
        Set<Trait> traits = traitsDTO.getTraits().stream().map(TraitConverter::fromDTO).collect(Collectors.toSet());
        user.setTraits(traits);
        return userRepository.save(user);
    }

    public User setInterests(Long userId, UserInterestsDTO userInterestsDTO) {
        User user = findOne(userId);
        Set<Interest> interests = new HashSet<>();
        for (InterestDTO dto : userInterestsDTO.getInterests()) {
            interests.add(interestService.findOne(dto.getId()));
        }
        user.setInterests(interests);
        return userRepository.save(user);
    }

    public List<User> findFriends(Long userId) {
        return userRepository.findFriendsById(userId);
    }
}
