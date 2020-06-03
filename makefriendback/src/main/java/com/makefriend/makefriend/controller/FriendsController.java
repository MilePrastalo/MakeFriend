package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.dto.FriendRequestDTO;
import com.makefriend.makefriend.dto.FriendSuggestionDTO;
import com.makefriend.makefriend.dto.SendFriendRequestDTO;
import com.makefriend.makefriend.dto.UserBasicDto;
import com.makefriend.makefriend.model.FriendRequest;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.service.FriendRequestService;
import com.makefriend.makefriend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/friends", produces = MediaType.APPLICATION_JSON_VALUE)
public class FriendsController {

    private final FriendRequestService friendRequestService;
    private final UserService userService;


    public FriendsController(FriendRequestService friendRequestService,UserService userService) {
        this.friendRequestService = friendRequestService;
        this.userService = userService;
    }

    @GetMapping("suggested")
    public ResponseEntity<List<FriendSuggestionDTO>> getSuggestedFriend() {
        List<FriendSuggestionDTO> newList = friendRequestService.suggestFriends();
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
