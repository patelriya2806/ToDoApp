package com.model;

public class user {
    private int userID;
    private String username;
    private String email;
    private String password;

    public user(){}

    public user(String username, String email , String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //getters
    public int getUserId() {
        return userID;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    //setters
    public void setUsername(String name) {
        this.username = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String pass) {
        this.password = pass;
    }
    public void setUserId(int userID) {
        this.userID = userID;
    }




}
