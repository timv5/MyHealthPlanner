package com.example.myhealthplanner.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myhealthplanner.database.model.FoodPlan;

import java.util.List;

@Dao
public interface FoodPlanDao {

    @Insert
    void insert(FoodPlan foodPlan);

    @Update
    void update(FoodPlan foodPlan);

    @Delete
    void delete(FoodPlan foodPlan);

    @Query(SqlConstants.DELETE_ALL_FOOD_PLANS)
    void deleteAllWorkoutPlans();

    @Query(SqlConstants.GET_ALL_FOOD_PLANS)
    LiveData<List<FoodPlan>> getAllFoodPlans();

    @Query(SqlConstants.DELETE_FOOD_PLAN_BY_ID)
    void deleteFoodPlanById(int foodPlanId);

    @Query(SqlConstants.GET_FOOD_PLAN_BY_ID)
    LiveData<FoodPlan> getFoodPlanById(int foodPlanId);

    class SqlConstants {

        private static final String GET_ALL_FOOD_PLANS = "SELECT * FROM food_plan" +
                " ORDER BY date_started DESC";
        private static final String GET_FOOD_PLAN_BY_ID = "SELECT * FROM food_plan" +
                " WHERE food_plan_id = :foodPlanId";
        private static final String DELETE_ALL_FOOD_PLANS = "DELETE FROM food_plan";
        private static final String DELETE_FOOD_PLAN_BY_ID = "DELETE FROM food_plan" +
                " WHERE food_plan_id = :foodPlanId";

    }

}
