package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.model.Report;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.service.KnowlageService;
import com.makefriend.makefriend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("api/report")
public class ReportController {
    private KnowlageService knowlageService;
    private UserService userService;
    public ReportController(KnowlageService knowlageService, UserService userService) {
        this.knowlageService = knowlageService;
        this.userService = userService;
    }

    @GetMapping("{username}")
    public void report(@PathVariable("username") String username){
        Report r = new Report(new Date(),username);
        knowlageService.getKieSession().insert(r);
        knowlageService.getKieSession().fireAllRules();
        if(r.getBan()){
            User u = userService.findOneByUsename(username);
            u.setBanned(r.getBan());
            userService.save(u);
        }
    }
}
