package com.makefriend.makefriend.model;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import javax.persistence.*;
import java.util.Date;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("24h")
@Entity
public class Report {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Date executionTime;
    @ManyToOne
    private User reported;
    @ManyToOne
    private User reportedBy;
    @Column
    private Boolean ban;

    public Report() {
    }

    public Report(Date executionTime, User reported, User reportedBy, Boolean ban) {
        this.executionTime = executionTime;
        this.reported = reported;
        this.reportedBy = reportedBy;
        this.ban = ban;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public User getReported() {
        return reported;
    }

    public void setReported(User reported) {
        this.reported = reported;
    }

    public User getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(User reportedBy) {
        this.reportedBy = reportedBy;
    }

    public Boolean getBan() {
        return ban;
    }

    public void setBan(Boolean ban) {
        this.ban = ban;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
