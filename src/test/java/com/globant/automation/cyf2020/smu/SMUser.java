package com.globant.automation.cyf2020.smu;

public class SMUser {



    private String usersEmail;
    private String password;
    private String usersJob;
    private String name;
    private String lastName;

    public SMUser() {
        // TODO Auto-generated constructor stub
    }

    public SMUser(String usersEmail, String password, String usersJob,String name, String lastName) {
        this.password = password;
        this.usersJob = usersJob;
        this.name = name;
        this.lastName = lastName;
        this.usersEmail = usersEmail;

    }


    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsersJob(String usersJob) {
        this.usersJob =  usersJob;
    }

    public String getUsersJob() {
        return usersJob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
}

