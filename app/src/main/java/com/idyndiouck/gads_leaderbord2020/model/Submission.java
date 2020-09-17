package com.idyndiouck.gads_leaderbord2020.model;

public class Submission {
    private String firstName;
    private String lastName;
    private String email;
    private String projectUrl;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public boolean isCorrect(){
        return firstName.length() > 0 && lastName.length() > 0 && email.length() > 0 && projectUrl.length() > 0;
    }
}
