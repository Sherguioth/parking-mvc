package com.sherguioth.parking.manager;

import com.sherguioth.parking.shift.ShiftEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "managers")
public class ManagerEntity implements Serializable {
    @Id
    @Column(name = "manager_id")
    private long managerId;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private byte[] salt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shift_id")
    private ShiftEntity shift;

    public ManagerEntity() {}

    public ManagerEntity(long managerId, String name, String username, String password, byte[] salt, ShiftEntity shift) {
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

    public ShiftEntity getShift() {
        return shift;
    }

    public void setShift(ShiftEntity shift) {
        this.shift = shift;
    }
}
