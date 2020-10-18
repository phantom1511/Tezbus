package com.dastan.tezbus.ui.travel;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dastan.tezbus.R;
import com.dastan.tezbus.Travel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TravelResultFragment extends Fragment {

    private RecyclerView travelRecyclerView;
    private static List<Travel> travelList;
    private static TravelResultAdapter travelResultAdapter;
    private FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_travel_result, container, false);
        initViews(view);
        initListeners();
        return view;
    }

    private void initViews(View view){
        travelRecyclerView = view.findViewById(R.id.rvTravel);
        floatingActionButton = view.findViewById(R.id.fabAdd);
    }

    private void initListeners(){
        travelList = new ArrayList<>();
        travelList.add(new Travel("1","20.09.2020", "10:00", "Talas-Bishkek", "500 som", "После обеда не актуально"));
        travelList.add(new Travel("1","20.09.2020", "10:30", "Talas-Bishkek", "400 som", "После обеда не актуально"));
        travelList.add(new Travel("1","20.09.2020", "12:30", "Talas-Bishkek", "400 som", "После обеда не актуально"));
        travelList.add(new Travel("1","20.09.2020", "12:00", "Talas-Bishkek", "500 som", "После обеда не актуально"));
        travelList.add(new Travel("1","20.09.2020", "10:30", "Talas-Bishkek", "500 som", "После обеда не актуально"));
        travelList.add(new Travel("1","20.09.2020", "10:00", "Bishkek-Talas", "400 som", "После обеда не актуально"));
        travelRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        travelResultAdapter = new TravelResultAdapter(travelList);
        travelRecyclerView.setAdapter(travelResultAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}