package com.example.myhealthplanner.ui.foodplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myhealthplanner.R;
import com.example.myhealthplanner.database.model.FoodPlan;
import com.example.myhealthplanner.util.VerticalSpacingItemDecoration;

import java.util.List;

public class FoodPlanFragment extends Fragment {

    private static final String TAG = "FoodPlanFragment";

    private FoodPlanViewModel foodPlanViewModel;
    private RecyclerView recyclerView;
    private AppCompatButton buttonAddNewFoodPlan;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<FoodPlan> foodPlanList;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_foodplan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonAddNewFoodPlan = view.findViewById(R.id.fragment_food_plan_add_new);
        buttonAddNewFoodPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NewFoodPlanActivity.class));
            }
        });

        recyclerView = view.findViewById(R.id.fragment_food_plan_recycler_view);
        final FoodPlanRecyclerViewAdapter adapter = new FoodPlanRecyclerViewAdapter();
        initRecyclerView(adapter);
        onSwipeRefresh(view, adapter);
        onDeleteListener();
    }

    private void onDeleteListener() {
        ItemTouchHelper.SimpleCallback simpleCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView,
                                          @NonNull RecyclerView.ViewHolder viewHolder,
                                          @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int direction) {
                        final int position = viewHolder.getAdapterPosition();
                        if (ItemTouchHelper.RIGHT == direction) {
                            foodPlanViewModel.delete(foodPlanList.get(position));
                        }
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void initRecyclerView(FoodPlanRecyclerViewAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        VerticalSpacingItemDecoration itemDecoration = new VerticalSpacingItemDecoration(15);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
        foodPlanViewModel = new ViewModelProvider(this).get(FoodPlanViewModel.class);
        initViewModel(adapter);
    }

    private void initViewModel(FoodPlanRecyclerViewAdapter adapter) {
        foodPlanViewModel.getFoodPlanLiveData().observe(getViewLifecycleOwner(), new Observer<List<FoodPlan>>() {
            @Override
            public void onChanged(List<FoodPlan> foodPlans) {
                adapter.setFoodPlanList(foodPlans);
                foodPlanList = foodPlans;
            }
        });
    }
//
    private void onSwipeRefresh(View view, FoodPlanRecyclerViewAdapter adapter) {
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initViewModel(adapter);
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}