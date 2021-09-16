package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Add_A_Bicycle extends AppCompatActivity {
    RecyclerView recyclerView;
    MainAdapterChamath mainAdapterChamath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_abicycle);

        recyclerView = (RecyclerView)findViewById(R.id.brv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<BikeRetreiveMainModel> options =
                new FirebaseRecyclerOptions.Builder<BikeRetreiveMainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Bicycle Management"), BikeRetreiveMainModel.class)
                        .build();

    mainAdapterChamath = new MainAdapterChamath(options);
    recyclerView.setAdapter(mainAdapterChamath);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapterChamath.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapterChamath.stopListening();
    }
}