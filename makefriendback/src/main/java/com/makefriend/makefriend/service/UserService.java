package com.makefriend.makefriend.service;

import com.makefriend.makefriend.dto.InterestDTO;
import com.makefriend.makefriend.dto.ProfileDetailsDTO;
import com.makefriend.makefriend.dto.UserTraitDTO;
import com.makefriend.makefriend.model.Interest;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.model.UserTrait;
import com.makefriend.makefriend.repository.UserRepository;
import com.makefriend.makefriend.repository.UserTraitRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final InterestService interestService;
    private final TraitService traitService;
    private final UserTraitRepository userTraitRepository;

    public UserService(UserRepository userRepository, InterestService interestService, TraitService traitService, UserTraitRepository userTraitRepository) {
        this.userRepository = userRepository;
        this.interestService = interestService;
        this.traitService = traitService;
        this.userTraitRepository = userTraitRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User findOneByUsename(String username){
        return userRepository.findByUsername(username);
    }

    public User findOne(Long id) {
        return userRepository.findById(id).get();
    }

    public List<Interest> getInterests(String username) {
        User user = userRepository.findByUsername(username);
        return new ArrayList<>(user.getInterests());
    }

    public List<UserTrait> getTraits(String username) {
        User user = userRepository.findByUsername(username);
        return new ArrayList<>(user.getTraits());
    }

    public User setUserDetails(String username,  ProfileDetailsDTO profileDetailsDTO) {
        User user = userRepository.findByUsername(username);
        user.setFirstName(profileDetailsDTO.getFirstName());
        user.setLastName(profileDetailsDTO.getLastName());
        user.setEmail(profileDetailsDTO.getEmail());
        return userRepository.save(user);
    }
    public User setTraits(String username, List<UserTraitDTO> traitsDTO) {
        User user = userRepository.findByUsername(username);
        for (UserTraitDTO utDto: traitsDTO){
            Optional<UserTrait> ut = user.getTraits().stream().filter(userTrait -> userTrait.getTrait().getName().equals(utDto.getName())).findFirst();
            if(ut.isPresent()){
                ut.get().setValue(utDto.getValue());
                userTraitRepository.save(ut.get());
            }else{
                UserTrait newUserTrait = new UserTrait();
                newUserTrait.setTrait(traitService.findByName(utDto.getName()));
                newUserTrait.setValue(utDto.getValue());
                newUserTrait = userTraitRepository.save(newUserTrait);
                user.getTraits().add(newUserTrait);
            }
        }
        return userRepository.save(user);
    }

    public User setInterests(String username, List<InterestDTO> userInterestsDTO) {
        User user = userRepository.findByUsername(username);
        Set<Interest> interests = new HashSet<>();
        for (InterestDTO dto : userInterestsDTO) {
            interests.add(interestService.findByName(dto.getName()));
        }
        user.setInterests(interests);
        return userRepository.save(user);
    }

    public List<User> findFriends(Long userId) {
        return userRepository.findFriendsById(userId);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User getUserFromAuthentication(){
        String username = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            username = authentication.getName();
        } else {
            return null;
        }
        return findOneByUsename(username);
    }
}
