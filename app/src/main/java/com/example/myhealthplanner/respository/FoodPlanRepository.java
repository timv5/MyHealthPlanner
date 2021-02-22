package com.example.myhealthplanner.respository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.myhealthplanner.database.dao.FoodPlanDao;
import com.example.myhealthplanner.database.db.AppDatabase;
import com.example.myhealthplanner.database.model.FoodPlan;

import java.util.List;

public class FoodPlanRepository {

    private final FoodPlanDao foodPlanDao;

    public FoodPlanRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        this.foodPlanDao = database.foodPlanDao();
    }

    public void insert(FoodPlan foodPlan) {
        this.foodPlanDao.insert(foodPlan);
    }

    public void update(FoodPlan foodPlan) {
        this.foodPlanDao.update(foodPlan);
    }

    public void delete(FoodPlan foodPlan) {
        this.foodPlanDao.delete(foodPlan);
    }

    public void deleteAllFoodPlans() {
        this.foodPlanDao.deleteAllWorkoutPlans();
    }

    public LiveData<List<FoodPlan>> getAllWorkoutPlans() {
        return this.foodPlanDao.getAllFoodPlans();
    }

    public void deleteWorkoutPlanById(int foodPlanId) {
        this.foodPlanDao.deleteFoodPlanById(foodPlanId);
    }

    public LiveData<FoodPlan> getWorkoutPlanById(int foodPlanId) {
        return this.foodPlanDao.getFoodPlanById(foodPlanId);
    }
}
