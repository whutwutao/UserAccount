package com.whut.useraccount.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserAccount {
    private int id;
    private String name;
    private String password;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private float deposit;

    public UserAccount() {
    }

    public UserAccount(int id, String name, String password, String gender, Date birth, float deposit) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.birth = birth;
        this.deposit = deposit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                ", deposit=" + deposit +
                '}';
    }
}
