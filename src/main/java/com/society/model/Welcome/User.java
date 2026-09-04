package com.society.model.Welcome;

public class User {

    private String name;
    private String email;
    private String password;
    private String role;
    private String flatNo;

    public User() {
    }

    public User(
            String name,
            String email,
            String password,
            String role) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(
            String name,
            String email,
            String password,
            String role,
            String flatNo) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.flatNo = flatNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }
}
