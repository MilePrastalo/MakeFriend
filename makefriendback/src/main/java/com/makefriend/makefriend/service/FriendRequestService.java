package com.makefriend.makefriend.service;

import com.makefriend.makefriend.dto.FriendSuggestionDTO;
import com.makefriend.makefriend.dto.SendFriendRequestDTO;
import com.makefriend.makefriend.model.FriendMatch;
import com.makefriend.makefriend.model.FriendRequest;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.repository.FriendRequestRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendRequestService {
    private final FriendRequestRepository friendRequestRepository;
    private final UserService userService;
    private final KieContainer kieContainer;

    public FriendRequestService(FriendRequestRepository friendRequestRepository, UserService userService, KieContainer kieContainer) {
        this.friendRequestRepository = friendRequestRepository;
        this.userService = userService;
        this.kieContainer = kieContainer;
    }

    public List<User> getFriends() {
        User user = userService.getUserFromAuthentication();
        return new ArrayList<>(user.getFriends());
    }

    public List<FriendRequest> getFriendRequests() {
        User user = userService.getUserFromAuthentication();
        return new ArrayList<>(user.getReceivedFriendRequests());
    }

    public void sendFriendRequest(SendFriendRequestDTO dto) {
        User sender = userService.findOneByUsename(dto.getSender());
        User receiver = userService.findOneByUsename(dto.getReceiver());
        FriendRequest request = new FriendRequest();
        request.setReceiver(receiver);
        request.setSender(sender);
        request = friendRequestRepository.save(request);
        sender.getSentFriendRequests().add(request);
        receiver.getReceivedFriendRequests().add(request);
        userService.save(sender);
        userService.save(receiver);
    }

    public void acceptFriendRequest(Long requestId) {
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

    public void rejectFriendRequest(Long requestId) {
        FriendRequest request = friendRequestRepository.findById(requestId).get();
        User sender = request.getSender();
        User receiver = request.getReceiver();
        sender.getSentFriendRequests().remove(request);
        receiver.getReceivedFriendRequests().remove(request);
        userService.save(sender);
        userService.save(receiver);
        friendRequestRepository.delete(request);
    }

    public ArrayList<FriendSuggestionDTO> suggestFriends() {
        User user = userService.getUserFromAuthentication();
        List<FriendSuggestionDTO> suggestions = new ArrayList<>();

        List<User> users = userService.findAll();
        //dont show existing friends and friend requests
        users = filterNotExist(users, new ArrayList(user.getFriends()));
        List<User> sentFriendRequest = user.getSentFriendRequests().stream().map(FriendRequest::getReceiver).collect(Collectors.toList());
        List<User> receivedFriendRequests = user.getReceivedFriendRequests().stream().map(FriendRequest::getSender).collect(Collectors.toList());
        users = filterNotExist(users, sentFriendRequest);
        users = filterNotExist(users, receivedFriendRequests);

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

            FriendSuggestionDTO s = new FriendSuggestionDTO(u.getId(), u.getFirstName(), u.getLastName(), fm.getSimilar(), u.getUsername());
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
        return newList;
    }

    private List<User> filterNotExist(List<User> first, List<User> second) {
        ArrayList<User> newList = new ArrayList<>();
        for (User u : first) {
            boolean exist = false;
            for (User u2 : second) {
                if (u2.getId().equals(u.getId())) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                newList.add(u);
            }
        }
        return newList;
    }
}
