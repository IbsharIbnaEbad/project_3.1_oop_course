package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface userinfoDao {
    @Query("select * from  users")
    List<usersinfo>getAlluserinfo();
    @Insert
    void adduser(usersinfo users );
    @Update
    void upuser(usersinfo users );
    @Delete
    void deluser(usersinfo users );
}
