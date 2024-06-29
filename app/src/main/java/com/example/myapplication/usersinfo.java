package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class usersinfo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "password")
    private int password;
    @ColumnInfo(name = "cpassword")
    private int cpassword;
    @ColumnInfo(name = "fristname")
    private String fristname;
    @ColumnInfo(name = "lastname")
    private String lastname;
    @ColumnInfo(name = "phonenumber")
    private int phonenumber;

    usersinfo(String fristname, String lastname) {
        this.id = id;
        this.fristname = fristname;
        this.lastname = lastname;
        this.password = password;
        this.cpassword = cpassword;
        this.phonenumber = phonenumber;

    }

    @Ignore
    usersinfo(String fristname, String lastname, int password, int phonenumber, int cpassword) {

        this.fristname = fristname;
        this.lastname = lastname;
        this.password = password;
        this.cpassword = cpassword;
        this.phonenumber = phonenumber;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getCpassword() {
        return cpassword;
    }

    public void setCpassword(int cpassword) {
        this.cpassword = cpassword;
    }

    public String getFristname() {
        return fristname;
    }

    public void setFristname(String fristname) {
        this.fristname = fristname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
}
