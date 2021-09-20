package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;

public class Event_List extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapterVinod mainAdapterVinod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        recyclerView = (RecyclerView)findViewById(R.id.bevents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<BikeRetreiveMainModel> options =
                new FirebaseRecyclerOptions.Builder<BikeRetreiveMainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Bicycle Management"), BikeRetreiveMainModel.class)
                        .build();

        mainAdapterVinod = new MainAdapterVinod(options);
        recyclerView.setAdapter(mainAdapterVinod);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapterVinod.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapterVinod.stopListening();
    }

}