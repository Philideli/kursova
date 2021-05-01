package com.example.model;


public class User {
    private String login;
    private String password;
    private String phone;
    private Integer id;

    public User(String login, String password, String phone, Integer id) {
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}