package com.makefriend.makefriend.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import com.makefriend.makefriend.model.*;
import com.makefriend.makefriend.repository.ReportRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
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
public class ReportServiceTest {

    @MockBean
    private UserService userService;

    @MockBean
    private ReportRepository reportRepository;


    @Autowired
    private ReportService reportService;

    private User u1;
    private User u2;

    @Before
    public void setUp() {
        u1 = new User();
        u1.setId(1l);
        u1.setFirstName("Ime1");
        u1.setLastName("Prezime1");
        u1.setUsername("Pera");
        Set<Interest> u1Interests = new HashSet<>();
        u1.setInterests(u1Interests);
        u1.setTraits(new HashSet<>());
        u1.setFriends(new HashSet<>());
        u1.setSentFriendRequests(new HashSet<>());
        u1.setReceivedFriendRequests(new HashSet<>());

        u2 = new User();
        u2.setId(2l);
        u2.setFirstName("Ime2");
        u2.setLastName("Prezime2");
        u2.setUsername("Zika");
        Set<Interest> u2Interests = new HashSet<>();
        u2.setInterests(u2Interests);
        u2.setTraits(new HashSet<>());
        u2.setFriends(new HashSet<>());
        u2.setSentFriendRequests(new HashSet<>());
        u2.setReceivedFriendRequests(new HashSet<>());
        u2.setBanned(false);



        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);

        Mockito.when(userService.findOneByUsename("Zika")).thenReturn(u2);
        Mockito.when(userService.save(u2)).thenReturn(u2);
        Mockito.when(reportRepository.save(ArgumentMatchers.any(Report.class))).thenReturn(new Report());
        Mockito.when(userService.getUserFromAuthentication()).thenReturn(u1);
    }

    @Test
    public void ReportTest() throws InterruptedException {
        for (int i = 0; i<5; i++){
            reportService.report("Zika");
            if(i<4){
                assertFalse(u2.getBanned());
            }else{
                assertTrue(u2.getBanned());
            }
            Thread.sleep(1000);
        }
    }
}
