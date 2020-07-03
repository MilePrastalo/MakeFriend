package com.makefriend.makefriend.service;

import com.makefriend.makefriend.model.Report;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final KnowlageService knowlageService;
    private final UserService userService;
    private final ReportRepository reportRepository;

    public ReportService(KnowlageService knowlageService, UserService userService, ReportRepository reportRepository) {
        this.knowlageService = knowlageService;
        this.userService = userService;
        this.reportRepository = reportRepository;
    }

    public User report(String username) {
        User reported = userService.findOneByUsename(username);
        User reportedBy = userService.getUserFromAuthentication();
        Report r = new Report(new Date(), reported, reportedBy, false);
        knowlageService.getKieSession().getAgenda().getAgendaGroup("report").setFocus();
        knowlageService.getKieSession().insert(r);
        knowlageService.getKieSession().fireAllRules();
        if (r.getBan()) {
            User u = userService.findOneByUsename(username);
            u.setBanned(r.getBan());
            userService.save(u);
        }
        reportRepository.save(r);
        return reported;
    }
    public List<User> getReportedByUser(){
        User loggedIn = userService.getUserFromAuthentication();
        List<Report> reports = reportRepository.findByReportedBy(loggedIn);
        List<User> users = reports.stream().map(Report::getReported).collect(Collectors.toList());
        return users;
    }
}
