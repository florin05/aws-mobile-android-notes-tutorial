package com.amazonaws.mobile.samples.mynotes.models;

import java.sql.Driver;

public enum DriverStatus {
    AVAILALBLE("Available"),
    UNAVILABLE("Unavailable"),
    ONROUTE("On Route");
    private final String label;

    DriverStatus(final String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
