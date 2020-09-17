package com.idyndiouck.gads_leaderbord2020.model;

public class SkillLeader {
    private String name;
    private String country;
    private int score;

    public SkillLeader(String name, String country, int score) {
        this.name = name;
        this.country = country;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getScore() {
        return score;
    }

}
