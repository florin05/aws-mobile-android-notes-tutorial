package com.amazonaws.mobile.samples.mynotes.models;

import java.sql.Driver;

public enum DriverStatus {
    AVAILALBLE("Available tp pickup STAT orders"),
    UNAVILABLE("Unavailable to pickup STAT orders"),
    ONROUTE("On Route to pickup STAT order");
    private final String label;

    DriverStatus(final String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    public String getStatusChangeLabel() {
        return this.compareTo(DriverStatus.AVAILALBLE) == 0 ?
                "Change to Unavailable": "Change to Available";
    }
    public Boolean isAvailable() {
        return this.compareTo(DriverStatus.AVAILALBLE) == 0;
    }


}
