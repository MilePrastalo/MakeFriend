package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.dto.FriendRequestDTO;
import com.makefriend.makefriend.dto.FriendSuggestionDTO;
import com.makefriend.makefriend.dto.SendFriendRequestDTO;
import com.makefriend.makefriend.dto.UserBasicDto;
import com.makefriend.makefriend.model.FriendMatch;
import com.makefriend.makefriend.model.FriendRequest;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.service.FriendRequestService;
import com.makefriend.makefriend.service.InterestCategoryService;
import com.makefriend.makefriend.service.InterestService;
import com.makefriend.makefriend.service.UserService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/friends", produces = MediaType.APPLICATION_JSON_VALUE)
public class FriendsController {

    private final FriendRequestService friendRequestService;
    private final KieContainer kieContainer;
    private InterestService interestService;
    private InterestCategoryService interestCategoryService;
    private UserService userService;


    public FriendsController(FriendRequestService friendRequestService, KieContainer kieContainer, InterestService interestService, InterestCategoryService interestCategoryService, UserService userService) {
        this.friendRequestService = friendRequestService;
        this.kieContainer = kieContainer;
        this.interestService = interestService;
        this.interestCategoryService = interestCategoryService;
        this.userService = userService;
    }

    @GetMapping("suggested")
    public ResponseEntity<List<FriendSuggestionDTO>> getSuggestedFriend() {
        User user = userService.getUserFromAuthentication();
        List<FriendSuggestionDTO> suggestions = new ArrayList<>();

        List<User> users = userService.findAll();
        List<FriendMatch> friendMatchList = new ArrayList<>();

        User userQuerry = users.stream().filter(u -> u.getId().equals(user.getId())).findFirst().get();

        for (User u : users) {
            if (u == userQuerry) {
                continue;
            }
            FriendMatch fm = new FriendMatch(userQuerry, u);
            friendMatchList.add(fm);
            KieSession session = kieContainer.newKieSession("session");
            session.insert(fm);
            session.getAgenda().getAgendaGroup("Traits").setFocus();
            session.fireAllRules();

            if (fm.getSimilarTraits() >= 0) {
                session.getAgenda().getAgendaGroup("Interests").setFocus();
                session.fireAllRules();
            }
            session.dispose();

            FriendSuggestionDTO s = new FriendSuggestionDTO(u.getId(), u.getFirstName(), u.getLastName(), fm.getSimilar());
            suggestions.add(s);
        }

        //Sort

        for (int i = 0; i < suggestions.size() - 1; i++) {
            for (int j = i + 1; j < suggestions.size(); j++) {
                if (suggestions.get(j).getSimmilar() > suggestions.get(i).getSimmilar()) {
                    FriendSuggestionDTO temp = suggestions.get(j);
                    suggestions.set(j, suggestions.get(i));
                    suggestions.set(i, temp);
                }
            }
        }
        //limit to 6
        ArrayList<FriendSuggestionDTO> newList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if (suggestions.size() <= i) {
                break;
            }
            newList.add(suggestions.get(i));
        }

        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<UserBasicDto>> getAllFriends() {
        String username = "";

        List<User> friends = friendRequestService.getFriends();
        List<UserBasicDto> basicFriends = friends.stream().map(UserBasicDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(basicFriends, HttpStatus.OK);
    }

   @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendFriendRequest(@RequestBody SendFriendRequestDTO dto) {
        friendRequestService.sendFriendRequest(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("accept/{requestId}")
    public ResponseEntity<Void> acceptFriendRequest(@PathVariable("requestId") Long requestId) {
        friendRequestService.acceptFriendRequest(requestId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("reject/{requestId}")
    public ResponseEntity<Void> rejectFriendRequest(@PathVariable("requestId") Long requestId) {
        friendRequestService.rejectFriendRequest(requestId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("requests")
    public ResponseEntity<List<FriendRequestDTO>> getFriendRequests() {
        List<FriendRequest> requests = friendRequestService.getFriendRequests();
        List<FriendRequestDTO> requestsDTO = requests.stream().map(FriendRequestDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(requestsDTO, HttpStatus.OK);
    }


}
