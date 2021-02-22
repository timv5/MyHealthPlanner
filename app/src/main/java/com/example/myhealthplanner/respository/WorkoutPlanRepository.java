package com.example.myhealthplanner.respository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.myhealthplanner.database.dao.WorkoutPlanDao;
import com.example.myhealthplanner.database.db.AppDatabase;
import com.example.myhealthplanner.database.model.WorkoutPlan;

import java.util.List;

public class WorkoutPlanRepository {

    private final WorkoutPlanDao workoutPlanDao;

    public WorkoutPlanRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        this.workoutPlanDao = database.workoutPlanDao();
    }

    public void insert(WorkoutPlan workoutPlan) {
        this.workoutPlanDao.insert(workoutPlan);
    }

    public void update(WorkoutPlan workoutPlan) {
        this.workoutPlanDao.update(workoutPlan);
    }

    public void delete(WorkoutPlan workoutPlan) {
        this.workoutPlanDao.delete(workoutPlan);
    }

    public void deleteAllWorkoutPlans() {
        this.workoutPlanDao.deleteAllWorkoutPlans();
    }

    public LiveData<List<WorkoutPlan>> getAllWorkoutPlans() {
        return this.workoutPlanDao.getAllWorkoutPlans();
    }

    public void deleteWorkoutPlanById(int workoutPlanId) {
        this.workoutPlanDao.deleteWorkoutPlanById(workoutPlanId);
    }

    public LiveData<WorkoutPlan> getWorkoutPlanById(int workoutPlanId) {
        return this.workoutPlanDao.getWorkoutPlanById(workoutPlanId);
    }


}
