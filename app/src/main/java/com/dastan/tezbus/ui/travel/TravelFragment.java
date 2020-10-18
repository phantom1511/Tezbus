package com.dastan.tezbus.ui.travel;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.dastan.tezbus.R;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class TravelFragment extends Fragment implements DatePickerDialog.OnDateSetListener{

    private Button btnNext;
    private NiceSpinner dateFromSp;
    private NiceSpinner dateBackSp;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_travel, container, false);
        final TextView textView = root.findViewById(R.id.tvTravelTitle);
        NiceSpinner nSFrom = (NiceSpinner) root.findViewById(R.id.spFrom);
        List<String> dsFrom = new LinkedList<>(Arrays.asList("Talas", "Bishkek", "Osh", "Naryn", "Yssyk-kol","Jalal-Abad"));
        nSFrom.attachDataSource(dsFrom);
        NiceSpinner nSWhere = (NiceSpinner) root.findViewById(R.id.spWhere);
        List<String> dsWhere = new LinkedList<>(Arrays.asList("Talas", "Bishkek", "Osh", "Naryn", "Yssyk-kol","Jalal-Abad"));
        nSWhere.attachDataSource(dsWhere);
        NiceSpinner nSDate = (NiceSpinner) root.findViewById(R.id.spData);
        List<String> dsDate = new LinkedList<>(Arrays.asList("20.01.2020", "20.02.2020", "20.03.2020", "20.04.2020", "20.05.2020","20.06.2020"));
        nSDate.attachDataSource(dsDate);
        NiceSpinner nSDateBack = (NiceSpinner) root.findViewById(R.id.spBackData);
        List<String> dsDateBack = new LinkedList<>(Arrays.asList("20.01.2020", "20.02.2020", "20.03.2020", "20.04.2020", "20.05.2020","20.09.2020"));
        nSDateBack.attachDataSource(dsDateBack);
//        niceSpinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
//            @Override
//            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
//                // This example uses String, but your type can be any
//                String item = (String) parent.getItemAtPosition(position);
//            }
//        });

        initViews(root);
        initListener();

        return root;
    }

    private void initViews(View view){
        btnNext = view.findViewById(R.id.btnNext);
    }

    private void initListener(){
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireActivity(),R.id.nav_host_fragment)
                        .navigate(R.id.action_navigation_travel_to_travelResultFragment);
            }
        });


//        dateFromSp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DialogFragment datePicker = new DatePickerFragment();
//                datePicker.show(getFragmentManager(), "date picker");
//            }
//        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int day, int month, int year) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.YEAR, year);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        dateFromSp.setText(currentDateString);
    }
}