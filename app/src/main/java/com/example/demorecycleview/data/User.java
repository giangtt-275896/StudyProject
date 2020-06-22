package com.example.demorecycleview.data;

import com.example.demorecycleview.R;

public class User {

    private String userName = "Peter";
    private String userAddress = "England";

    public User() {
    }

    public User(String userName, String userAddress) {
        this.userName = userName;
        this.userAddress = userAddress;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
