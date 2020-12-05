package com.domain;

/**
 * @author gg
 * @create 2020-10-15 17:33
 */
public class AccountUser extends Account{
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                "} " + super.toString();
    }
}
