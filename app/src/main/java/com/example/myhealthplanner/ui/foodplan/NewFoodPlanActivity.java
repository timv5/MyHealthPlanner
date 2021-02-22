package com.example.myhealthplanner.ui.foodplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myhealthplanner.MainActivity;
import com.example.myhealthplanner.R;
import com.example.myhealthplanner.database.model.FoodPlan;
import com.example.myhealthplanner.ui.home.HomeViewModel;

import java.util.Date;

public class NewFoodPlanActivity extends AppCompatActivity {

    private static final String TAG = "NewFoodPlanActivity";

    private AppCompatButton buttonAddNew;
    private EditText editTextFoodPlanName;
    private EditText editTextFoodPlanDesc;
    private NewFoodPlanViewModel newFoodPlanViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_food_plan);
        newFoodPlanViewModel = new ViewModelProvider(this).get(NewFoodPlanViewModel.class);


        initUiElements();
        buttonAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextFoodPlanName.getText().toString();
                String desc = editTextFoodPlanDesc.getText().toString();
                FoodPlan foodPlan = setFoodPlan(name, desc);
                newFoodPlanViewModel.createNewFoodPlan(foodPlan);
                startActivity(new Intent(v.getContext(), MainActivity.class));
                finish();
            }
        });
    }

    private FoodPlan setFoodPlan(String name, String description) {
        return new FoodPlan(
                new Date(),
                new Date(),
                new Date(),
                name,
                description
        );
    }

    private void initUiElements() {
        editTextFoodPlanName = findViewById(R.id.editTextFoodPlanName);
        editTextFoodPlanDesc = findViewById(R.id.editTextFoodPlanDesc);
        buttonAddNew = findViewById(R.id.activity_new_food_plan_add_new);
    }
}