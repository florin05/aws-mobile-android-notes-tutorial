package com.amazonaws.mobile.samples.mynotes.models;

import java.util.Date;

public class DriverStatusInfo {

    private DriverStatus status;
    private Date lastStatusChange;

    public DriverStatusInfo(DriverStatus status, Date statusChangeTime ) {
        this.status = status;
        this.lastStatusChange = statusChangeTime;
    }

    public DriverStatusInfo(DriverStatus status) {
        this.status = status;
        this.lastStatusChange = new Date();
    }


    public void setStatus(DriverStatus status) { this.status = status;  }
    public DriverStatus getStatus() { return this.status; }

    public void setLastStatusChange(Date date) { this.lastStatusChange = date;};
    public Date getLastStatusChange() { return this.lastStatusChange; };

}
