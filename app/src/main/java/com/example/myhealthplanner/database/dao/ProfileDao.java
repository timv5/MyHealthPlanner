package com.example.myhealthplanner.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myhealthplanner.database.model.Profile;

@Dao
public interface ProfileDao {

    @Insert
    void insert(Profile profile);

    @Insert
    void update(Profile profile);

    @Query(SqlConstants.GET_PROFILE)
    LiveData<Profile> getProfile();

    class SqlConstants {

        private static final String GET_PROFILE = "select * from profile";

    }

}
