package com.idyndiouck.gads_leaderbord2020.model;

public class LearningLeader {
    private String name;
    private String country;
    private int hours;

    public LearningLeader(String name, String country, int hours) {
        this.name = name;
        this.country = country;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getHours() {
        return hours;
    }

}
