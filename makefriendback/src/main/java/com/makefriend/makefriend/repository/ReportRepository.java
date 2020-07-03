package com.makefriend.makefriend.repository;

import com.makefriend.makefriend.model.Report;
import com.makefriend.makefriend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report,Long> {
    public List<Report> findByReportedBy(User reportedBy);
}
