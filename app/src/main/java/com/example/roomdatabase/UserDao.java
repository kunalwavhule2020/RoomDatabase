package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertrecord(User  users);

    @Query("SELECT EXISTS(SELECT * FROM User Where uid = :userId)")
    Boolean is_exist(int userId);

    @Query("SELECT * FROM User")
    List<User> getallusers();

}
