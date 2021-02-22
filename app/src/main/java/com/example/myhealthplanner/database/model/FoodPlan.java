package com.example.myhealthplanner.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.myhealthplanner.database.converters.DateConverter;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeConverters(DateConverter.class)
@Entity(tableName = "food_plan")
public class FoodPlan {

    @ColumnInfo(name = "food_plan_id")
    @PrimaryKey(autoGenerate = true)
    private long foodPlanId;

    @ColumnInfo(name = "date_created")
    private Date dateCreated;

    @ColumnInfo(name = "date_started")
    private Date dateStarted;

    @ColumnInfo(name = "date_finished")
    private Date dateFinished;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    public FoodPlan(Date dateCreated, Date dateStarted, Date dateFinished, String name, String description) {
        this.dateCreated = dateCreated;
        this.dateStarted = dateStarted;
        this.dateFinished = dateFinished;
        this.name = name;
        this.description = description;
    }
}
