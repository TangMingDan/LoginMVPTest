package com.example.administrator.loginmvptest3.model;

public class User {
    private String usernum;
    private String userPass;
    private String useName;

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public User(String usernum, String userPass) {
        this.usernum = usernum;
        this.userPass = userPass;
    }

    public User() {
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
