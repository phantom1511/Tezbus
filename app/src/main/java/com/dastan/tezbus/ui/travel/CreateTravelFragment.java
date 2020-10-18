package com.dastan.tezbus.ui.travel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dastan.tezbus.R;
import com.dastan.tezbus.Travel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateTravelFragment extends Fragment {

    private Travel mTravel;
    private Button btnReady;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_travel, container, false);
        initViews(view);
        initListener();
        return view;

    }

    private void initViews(View view){
        btnReady = view.findViewById(R.id.btnReady);
    }

    private void initListener(){
        btnReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //saveToFirestore();
                Navigation.findNavController(requireActivity(),R.id.nav_host_fragment)
                        .navigate(R.id.action_createTravelFragment_to_travelResultFragment);
            }
        });
    }


    private void saveToFirestore(){
        FirebaseFirestore.getInstance()
                .collection("travel")
                .add(mTravel)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()){
                            mTravel.setId(task.getResult().getId());
                            Toast.makeText(getContext(), "Succeed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}