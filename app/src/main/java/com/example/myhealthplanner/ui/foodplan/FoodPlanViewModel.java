package com.example.myhealthplanner.ui.foodplan;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myhealthplanner.database.model.FoodPlan;
import com.example.myhealthplanner.respository.FoodPlanRepository;

import java.util.List;

public class FoodPlanViewModel extends AndroidViewModel {

    private FoodPlanRepository foodPlanRepository;
    private LiveData<List<FoodPlan>> foodPlanLiveData;

    public FoodPlanViewModel(@NonNull Application application) {
        super(application);
        foodPlanRepository = new FoodPlanRepository(application);
        foodPlanLiveData = this.foodPlanRepository.getAllWorkoutPlans();
    }

    public LiveData<List<FoodPlan>> getFoodPlanLiveData() {
        return foodPlanLiveData;
    }

    public void delete(FoodPlan foodPlan) {
        this.foodPlanRepository.delete(foodPlan);
    }

    public LiveData<FoodPlan> getByPosition(int foodPlanId) {
        return this.foodPlanRepository.getWorkoutPlanById(foodPlanId);
    }
}