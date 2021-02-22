package com.example.myhealthplanner.ui.foodplan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhealthplanner.R;
import com.example.myhealthplanner.database.model.FoodPlan;
import com.example.myhealthplanner.util.HelperUtil;

import java.util.ArrayList;
import java.util.List;

public class FoodPlanRecyclerViewAdapter extends RecyclerView.Adapter<FoodPlanRecyclerViewAdapter.FoodPlanHolder> {

    private List<FoodPlan> foodPlans = new ArrayList<>();

    @NonNull
    @Override
    public FoodPlanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.food_plan_item, parent, false);
        return new FoodPlanHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodPlanHolder holder, int position) {
        FoodPlan foodPlan = foodPlans.get(position);
        holder.textViewTitle.setText(foodPlan.getName());
        holder.textViewDescription.setText(foodPlan.getDescription());
        holder.textViewDate.setText(HelperUtil.formatDate(foodPlan.getDateStarted()));
    }

    @Override
    public int getItemCount() {
        return foodPlans.size();
    }

    public void setFoodPlanList(List<FoodPlan> list) {
        this.foodPlans = list;
        notifyDataSetChanged();
    }

    static class FoodPlanHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTitle;
        private final TextView textViewDescription;
        private final TextView textViewDate;

        public FoodPlanHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewDate = itemView.findViewById(R.id.text_view_date);
        }
    }

}
