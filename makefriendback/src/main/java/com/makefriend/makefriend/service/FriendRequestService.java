package com.makefriend.makefriend.service;

import com.makefriend.makefriend.dto.FriendRequestDTO;
import com.makefriend.makefriend.model.FriendRequest;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.repository.FriendRequestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendRequestService {
    private final FriendRequestRepository friendRequestRepository;
    private final UserService userService;

    public FriendRequestService(FriendRequestRepository friendRequestRepository, UserService userService) {
        this.friendRequestRepository = friendRequestRepository;
        this.userService = userService;
    }
    public List<User> getFriends(Long userid){
        User user = userService.findOne(userid);
        return new ArrayList<>(user.getFriends());
    }

    public List<FriendRequest> getFriendRequests(Long userId) {
        User user = userService.findOne(userId);
        return new ArrayList<>(user.getReceivedFriendRequests());
    }

    public void sendFriendRequest(FriendRequestDTO dto) {
        User sender = userService.findOne(dto.getSender());
        User receiver = userService.findOne(dto.getReceiver());
        FriendRequest request = new FriendRequest();
        request.setReceiver(receiver);
        request.setSender(sender);
        request = friendRequestRepository.save(request);
        sender.getSentFriendRequests().add(request);
        receiver.getReceivedFriendRequests().add(request);
        userService.save(sender);
        userService.save(receiver);
    }
    public void acceptFriendRequest(Long requestId){
        FriendRequest request = friendRequestRepository.findById(requestId).get();
        User sender = request.getSender();
        User receiver = request.getReceiver();
        sender.getSentFriendRequests().remove(request);
        receiver.getReceivedFriendRequests().remove(request);
        sender.getFriends().add(receiver);
        receiver.getFriends().add(sender);
        userService.save(sender);
        userService.save(receiver);
        friendRequestRepository.delete(request);
    }
    public void rejectFriendRequest(Long requestId){
        FriendRequest request = friendRequestRepository.findById(requestId).get();
        User sender = request.getSender();
        User receiver = request.getReceiver();
        sender.getSentFriendRequests().remove(request);
        receiver.getReceivedFriendRequests().remove(request);
        userService.save(sender);
        userService.save(receiver);
        friendRequestRepository.delete(request);
    }
}
