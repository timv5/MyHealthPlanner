package com.example.myhealthplanner.ui.profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myhealthplanner.database.model.Profile;
import com.example.myhealthplanner.respository.ProfileRepository;

public class ProfileViewModel extends AndroidViewModel {

    private ProfileRepository profileRepository;
    private LiveData<Profile> profileLiveData;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        profileRepository = new ProfileRepository(application);
        profileLiveData = this.profileRepository.get();
    }

    public LiveData<Profile> getProfileLiveData() {
        return profileLiveData;
    }

    public void save(Profile profile) {
        this.profileRepository.insert(profile);
    }

    public void update(Profile profile) {
        this.profileRepository.update(profile);
    }
}