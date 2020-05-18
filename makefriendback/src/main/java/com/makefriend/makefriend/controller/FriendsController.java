package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.dto.*;
import com.makefriend.makefriend.model.*;
import com.makefriend.makefriend.service.FriendRequestService;
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
    private KieContainer kieContainer;


    public FriendsController(FriendRequestService friendRequestService, KieContainer kieContainer) {
        this.friendRequestService = friendRequestService;
        this.kieContainer = kieContainer;
    }

    @GetMapping("suggested/{userId}")
    public ResponseEntity<FriendSuggestionsDTO> getSuggestedFriend(@PathVariable("userId") Long userId) {
        List<FriendSuggestionDTO> suggestions = new ArrayList<>();
        FriendSuggestionsDTO dto = new FriendSuggestionsDTO(suggestions);

        //Mock data
        User u1 = new User("pera01", "pass", "Petar", "Petrovic", "pera@pera.com", new ArrayList<>());
        User u2 = new User("mika", "pass", "Mika", "Mikic", "mika@pera.com", new ArrayList<>());
        User u3 = new User("laza", "pass", "Laza", "Lazic", "laza@pera.com", new ArrayList<>());

        u1.setId(1L);
        u2.setId(2L);
        u3.setId(3L);
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);

        Interest i1 = new Interest("Football");
        Interest i2 = new Interest("Basketball");
        Interest i3 = new Interest("Volleyball");
        Interest i4 = new Interest("TV Shows");
        Interest i5 = new Interest("Movies");
        Interest i6 = new Interest("FantasyBooks");
        Interest i7 = new Interest("DramaBooks");
        Interest i8 = new Interest("PoetryBooks");
        Interest i9 = new Interest("DetectiveBooks");
        Interest i10 = new Interest("HistoryBooks");
        Interest i11 = new Interest("Hip-hop");
        Interest i12 = new Interest("Rock");
        Interest i13 = new Interest("Metal");
        Interest i14 = new Interest("Pop");

        String c1 = "SPORT";
        String c2 = "TVMOVIE";
        String c3 = "BOOKS";
        String c4 = "MUSIC";

        List<String> categories = new ArrayList<>();
        categories.add(c1);
        categories.add(c2);
        categories.add(c3);
        categories.add(c4);

        u1.getInterests().add(i1);
        u1.getInterests().add(i2);
        u1.getInterests().add(i3);
        u1.getInterests().add(i4);

        u2.getInterests().add(i1);
        u2.getInterests().add(i6);
        u2.getInterests().add(i7);
        u2.getInterests().add(i8);
        u2.getInterests().add(i9);

        u3.getInterests().add(i1);
        u3.getInterests().add(i2);

        Trait t1 = new Trait("Smoking");
        Trait t2 = new Trait("Drinks");
        Trait t3 = new Trait("Active");
        Trait t4 = new Trait("University");

        u1.getTraits().add(new UserTrait(t1, true));
        u1.getTraits().add(new UserTrait(t2, true));
        u1.getTraits().add(new UserTrait(t3, false));
        u1.getTraits().add(new UserTrait(t3, false));

        u2.getTraits().add(new UserTrait(t1, true));
        u2.getTraits().add(new UserTrait(t2, true));
        u2.getTraits().add(new UserTrait(t3, false));
        u2.getTraits().add(new UserTrait(t3, false));

        u3.getTraits().add(new UserTrait(t1, false));
        u3.getTraits().add(new UserTrait(t2, false));
        u3.getTraits().add(new UserTrait(t3, true));
        u3.getTraits().add(new UserTrait(t3, true));


        List<FriendMatch> friendMatchList = new ArrayList<>();
        User userQuerry = users.stream().filter(user -> user.getId().equals(userId)).findFirst().get();

        for (User u : users) {
            if (u == userQuerry) {
                continue;
            }
            FriendMatch fm = new FriendMatch();

            fm.setUserAInterests(userQuerry.getInterests().stream().map(Interest::getName).collect(Collectors.toList()));
            fm.setUserATraits(new ArrayList<>(userQuerry.getTraits()));
            fm.setUserBInterests(u.getInterests().stream().map(Interest::getName).collect(Collectors.toList()));
            fm.setUserBTraits(new ArrayList<>(u.getTraits()));
            fm.setSimilar(0);
            fm.setMatchTraits(false);
            fm.setCheckedTraits(0);
            fm.setSimilarTraits(0);
            friendMatchList.add(fm);

            List<String> positiveATraits = new ArrayList<>();
            List<String> negativeATraits = new ArrayList<>();
            for (UserTrait ut1 : userQuerry.getTraits()) {
                if (ut1.isValue()) {
                    positiveATraits.add(ut1.getTrait().getName());
                } else {
                    negativeATraits.add(ut1.getTrait().getName());
                }
            }

            List<String> positiveBTraits = new ArrayList<>();
            List<String> negativeBTraits = new ArrayList<>();
            for (UserTrait ut1 : u.getTraits()) {
                if (ut1.isValue()) {
                    positiveBTraits.add(ut1.getTrait().getName());
                } else {
                    negativeBTraits.add(ut1.getTrait().getName());
                }
            }
            fm.setPossitiveATraits(positiveATraits);
            fm.setNegativeATraits(negativeATraits);
            fm.setPossitiveBTraits(positiveBTraits);
            fm.setNegativeBTraits(negativeBTraits);

            KieSession session = kieContainer.newKieSession("session");
            session.insert(fm);
            session.getAgenda().getAgendaGroup("Traits").setFocus();
            session.fireAllRules();

            if (fm.getSimilarTraits() >= 0) {
                session.getAgenda().getAgendaGroup("Interests").setFocus();
                session.fireAllRules();
            }
            session.dispose();

            FriendSuggestionDTO s = new FriendSuggestionDTO(u.getId(),u.getFirstName(),u.getLastName(),fm.getSimilar());
            suggestions.add(s);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("all/{userId}")
    public ResponseEntity<UsersBasicDTO> getAllFriends(@PathVariable("userId") Long userId) {
        List<User> friends = friendRequestService.getFriends(userId);
        List<UserBasicDto> basicFriends = friends.stream().map(UserBasicDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(new UsersBasicDTO(basicFriends), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendFriendRequest(@RequestBody FriendRequestDTO dto) {
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

    @GetMapping("requests/{userId}")
    public ResponseEntity<FriendRequestsDTO> getFriendRequests(@PathVariable("userId") Long userId) {
        List<FriendRequest> requests = friendRequestService.getFriendRequests(userId);
        List<FriendRequestDTO> requestsDTO = requests.stream().map(FriendRequestDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(new FriendRequestsDTO(requestsDTO), HttpStatus.OK);
    }

}
