package com.example.myhealthplanner.ui.profile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myhealthplanner.R;
import com.example.myhealthplanner.database.model.Profile;
import com.example.myhealthplanner.util.HelperUtil;

public class ProfileFragment extends Fragment {

    private final int CAMERA_INTENT = 1;

    private ProfileViewModel profileViewModel;
    private ImageView profileImage;
    private Bitmap bitmap;
    private Button buttonOnTakeImage;
    private Button buttonOnSaveImage;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profileImage = view.findViewById(R.id.profile_image);
        buttonOnTakeImage = view.findViewById(R.id.profile_button_photo);
        buttonOnSaveImage = view.findViewById(R.id.profile_button_photo_save);

        initializeLoadImage();
        initializeOnTakeImage();
        initializeOnSaveImage();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_INTENT) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                bitmap = (Bitmap) data.getExtras().get("data");
                if (bitmap != null) {
                    profileImage.setImageBitmap(bitmap);
                }
            }
        }
    }

    private void initializeOnSaveImage() {
        buttonOnSaveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profile profile = new Profile();
                profile.setProfileImage(HelperUtil.convertImage2ByteArray(bitmap));
                profileViewModel.update(profile);
            }
        });
    }

    private void initializeOnTakeImage() {
        buttonOnTakeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_INTENT);
            }
        });
    }

    private void initializeLoadImage() {
        this.profileViewModel.getProfileLiveData()
            .observe(getViewLifecycleOwner(), new Observer<Profile>() {
                @Override
                public void onChanged(Profile profile) {
                    if (profile != null && profile.getProfileImage() != null) {
                        profileImage.setImageBitmap(HelperUtil.convertByteArray2Image(profile.getProfileImage()));
                    }
                }
            });
    }
}