package com.society.model.Secretary_model;

public class ProfileModel {

    private String name;
    private String email;
    private String mobile;
    private String role;
    private String status;
    private String accountType;
    private String society;
    private String memberSince;

    public ProfileModel() {
    }

    public ProfileModel(
            String name,
            String email,
            String mobile,
            String role,
            String status,
            String accountType,
            String society,
            String memberSince) {

        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.role = role;
        this.status = status;
        this.accountType = accountType;
        this.society = society;
        this.memberSince = memberSince;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }
}