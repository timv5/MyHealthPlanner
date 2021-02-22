package com.example.myhealthplanner.ui.foodplan;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.myhealthplanner.database.model.FoodPlan;
import com.example.myhealthplanner.respository.FoodPlanRepository;

public class NewFoodPlanViewModel extends AndroidViewModel {

    private FoodPlanRepository foodPlanRepository;

    public NewFoodPlanViewModel(@NonNull Application application) {
        super(application);
        this.foodPlanRepository = new FoodPlanRepository(application);
    }

    public void createNewFoodPlan(FoodPlan foodPlan) {
        this.foodPlanRepository.insert(foodPlan);
    }
}