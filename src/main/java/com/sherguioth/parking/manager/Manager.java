package com.sherguioth.parking.manager;

import com.sherguioth.parking.shift.Shift;

public class Manager {
    private long managerId;
    private String name;
    private String username;
    private String password;
    private byte[] salt;
    private Shift shift;

    public Manager() {}

    public Manager(long managerId, String name, String username, String password, byte[] salt, Shift shift) {
        this.managerId = managerId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.shift = shift;
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
