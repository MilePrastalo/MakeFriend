package com.makefriend.makefriend.controller;

import com.makefriend.makefriend.dto.UserBasicDto;
import com.makefriend.makefriend.model.User;
import com.makefriend.makefriend.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/report")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("reported")
    public ResponseEntity<List<UserBasicDto>> getReportedByUser() {
        List<User> usersReported = reportService.getReportedByUser();
        List<UserBasicDto> dto = usersReported.stream().map(UserBasicDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("{username}")
    public ResponseEntity<UserBasicDto> report(@PathVariable("username") String username) {
        User reported = reportService.report(username);
        return new ResponseEntity<>(new UserBasicDto(reported), HttpStatus.OK);
    }

}
