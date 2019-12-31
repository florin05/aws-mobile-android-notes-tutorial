package com.amazonaws.mobile.samples.mynotes.models;

import java.math.BigInteger;
import java.util.Date;

public class DriverStatusInfo {

    private String id;
    private String userName;
    private DriverStatus status;
    private Date lastStatusChange;
    private Integer version;

    public DriverStatusInfo(DriverStatus status, Date statusChangeTime ) {
        this.status = status;
        this.lastStatusChange = statusChangeTime;
    }

    public DriverStatusInfo(DriverStatus status) {
        this.status = status;
        this.lastStatusChange = new Date();
    }

    public void setId(String id) { this.id = id;  }
    public String getId() { return this.id; }

    public void setStatus(DriverStatus status) { this.status = status;  }
    public DriverStatus getStatus() { return this.status; }

    public void setUserName(String user) { this.userName = user;  }
    public String getUserName() { return this.userName; }

    public void setLastStatusChange(Date date) { this.lastStatusChange = date;};
    public Date getLastStatusChange() { return this.lastStatusChange; };

    public void setVersion(Integer version) { this.version = version;};
    public Integer getVersion() { return this.version; };

}
