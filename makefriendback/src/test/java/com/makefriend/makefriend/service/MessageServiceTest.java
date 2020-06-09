package com.makefriend.makefriend.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.makefriend.makefriend.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase()
@SpringBootTest
public class MessageServiceTest {
    @MockBean
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @Before
    public void setUp() {
        InterestCategory sport = new InterestCategory();
        sport.setName("SPORT");
        sport.setId(1l);

        Interest football = new Interest();
        football.setName("Football");
        football.setCategory(sport);
        sport.setInterests(new HashSet<>());
        sport.getInterests().add(football);

        Interest basketball = new Interest();
        basketball.setName("Basketball");
        basketball.setCategory(sport);
        sport.getInterests().add(basketball);

        Trait smokes = new Trait("Smoking");

        User u1 = new User();
        u1.setId(1l);
        u1.setFirstName("Ime1");
        u1.setLastName("Prezime1");
        u1.setUsername("Pera");
        Set<Interest> u1Interests = new HashSet<>();
        u1Interests.add(football);
        u1.setInterests(u1Interests);
        u1.setTraits(new HashSet<>());
        u1.getTraits().add(new UserTrait(smokes,false));
        u1.setFriends(new HashSet<>());
        u1.setSentFriendRequests(new HashSet<>());
        u1.setReceivedFriendRequests(new HashSet<>());

        User u2 = new User();
        u2.setId(2l);
        u2.setFirstName("Ime2");
        u2.setLastName("Prezime2");
        u2.setUsername("Zika");
        Set<Interest> u2Interests = new HashSet<>();
        u2Interests.add(basketball);
        u2.setInterests(u2Interests);
        u2.setTraits(new HashSet<>());
        u2.getTraits().add(new UserTrait(smokes,false));
        u2.setFriends(new HashSet<>());
        u2.setSentFriendRequests(new HashSet<>());
        u2.setReceivedFriendRequests(new HashSet<>());

        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);

        Mockito.when(userService.findOneByUsename("Zika")).thenReturn(u2);
        Mockito.when(userService.getUserFromAuthentication()).thenReturn(u1);
    }

    @Test
    public void suggestMessageTest(){
        MessageSuggest ms = messageService.getSuggestedMessage("Zika");
        assertEquals(1,ms.getMessageSuggests().size());
        assertEquals("What is your favourite sport?",ms.getMessageSuggests().get(0).getText());
    }
}
