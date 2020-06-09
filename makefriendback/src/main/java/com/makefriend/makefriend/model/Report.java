package com.makefriend.makefriend.model;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.util.Date;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("2h30m")
public class Report {

    private Date executionTime;
    private String username;


    public Report(Date executionTime, String username) {
        this.executionTime = executionTime;
        this.username = username;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
