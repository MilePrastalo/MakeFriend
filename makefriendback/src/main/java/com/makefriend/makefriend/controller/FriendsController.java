package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.dto.FriendRequestDTO;
import com.makefriend.makefriend.dto.FriendRequestsDTO;
import com.makefriend.makefriend.dto.UserBasicDto;
import com.makefriend.makefriend.dto.UsersBasicDTO;
import com.makefriend.makefriend.model.FriendRequest;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.service.FriendRequestService;
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

    public FriendsController(FriendRequestService friendRequestService) {
        this.friendRequestService = friendRequestService;
    }

    @GetMapping("suggested/{userId}")
    public void getSuggestedFriend() {

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
