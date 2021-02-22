package com.example.myhealthplanner.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myhealthplanner.database.model.WorkoutPlan;

import java.util.List;

@Dao
public interface WorkoutPlanDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(WorkoutPlan workoutPlan);

    @Update
    void update(WorkoutPlan workoutPlan);

    @Delete
    void delete(WorkoutPlan workoutPlan);

    @Query(SqlConstants.DELETE_ALL_WORKOUT_PLANS)
    void deleteAllWorkoutPlans();

    @Query(SqlConstants.GET_ALL_WORKOUT_PLANS)
    LiveData<List<WorkoutPlan>> getAllWorkoutPlans();

    @Query(SqlConstants.DELETE_WORKOUT_PLAN_BY_ID)
    void deleteWorkoutPlanById(int workoutPlanId);

    @Query(SqlConstants.GET_WORKOUT_PLAN_BY_ID)
    LiveData<WorkoutPlan> getWorkoutPlanById(int workoutPlanId);

    public static class SqlConstants {

        private static final String GET_ALL_WORKOUT_PLANS = "SELECT * FROM workout_plan" +
                " ORDER BY date_started DESC";
        private static final String GET_WORKOUT_PLAN_BY_ID = "SELECT * FROM workout_plan" +
                " WHERE workout_plan_id = :workoutPlanId";
        private static final String DELETE_ALL_WORKOUT_PLANS = "DELETE FROM workout_plan";
        private static final String DELETE_WORKOUT_PLAN_BY_ID = "DELETE FROM workout_plan" +
                " WHERE workout_plan_id = :workoutPlanId";

    }

}
