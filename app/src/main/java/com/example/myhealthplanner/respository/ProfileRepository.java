package com.example.myhealthplanner.respository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.myhealthplanner.database.dao.ProfileDao;
import com.example.myhealthplanner.database.db.AppDatabase;
import com.example.myhealthplanner.database.model.Profile;

public class ProfileRepository {

    private final ProfileDao profileDao;

    public ProfileRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        this.profileDao = database.profileDao();
    }

    public void insert(Profile profile) {
        this.profileDao.insert(profile);
    }

    public void update(Profile profile) {
        this.profileDao.insert(profile);
    }

    public LiveData<Profile> get() {
        return this.profileDao.getProfile();
    }
}
