package com.makefriend.makefriend.service;

import com.makefriend.makefriend.dto.ProfileDetailsDTO;
import com.makefriend.makefriend.dto.UserTraitDTO;
import com.makefriend.makefriend.model.Interest;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.model.UserTrait;
import com.makefriend.makefriend.repository.UserRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final InterestService interestService;
    private final TraitService traitService;

    public UserService(UserRepository userRepository, InterestService interestService, TraitService traitService) {
        this.userRepository = userRepository;
        this.interestService = interestService;
        this.traitService = traitService;
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
//TODO
    public User setTraits(String username, List<UserTraitDTO> traitsDTO) {
        User user = userRepository.findByUsername(username);
        for (UserTraitDTO ut: traitsDTO) {
            UserTrait userTrait = new UserTrait();
            //userTrait.setTrait(traitService.findOne(ut));
        }
        Set<UserTrait> traits = traitsDTO.stream().map(userTraitDTO ->new UserTrait()).collect(Collectors.toSet());
        user.setTraits(traits);
        return userRepository.save(user);
    }

   /* public User setInterests(String username, UserInterestsDTO userInterestsDTO) {
        User user = userRepository.findByUsername(username);
        Set<Interest> interests = new HashSet<>();
        for (InterestDTO dto : userInterestsDTO.getInterests()) {
            interests.add(interestService.findOne(dto.getId()));
        }
        user.setInterests(interests);
        return userRepository.save(user);
    }*/

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
