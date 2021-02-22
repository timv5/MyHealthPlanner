package com.example.myhealthplanner.database.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myhealthplanner.database.dao.FoodPlanDao;
import com.example.myhealthplanner.database.dao.ProfileDao;
import com.example.myhealthplanner.database.dao.WorkoutPlanDao;
import com.example.myhealthplanner.database.model.FoodPlan;
import com.example.myhealthplanner.database.model.Profile;
import com.example.myhealthplanner.database.model.WorkoutPlan;

@Database(entities = {
        WorkoutPlan.class,
        FoodPlan.class,
        Profile.class
}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "my_health_planner_db";
    private static AppDatabase instance;

    public abstract WorkoutPlanDao workoutPlanDao();
    public abstract FoodPlanDao foodPlanDao();
    public abstract ProfileDao profileDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
