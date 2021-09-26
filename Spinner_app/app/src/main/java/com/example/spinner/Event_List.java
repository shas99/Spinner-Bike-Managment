package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.widget.TextView;

public class Event_List extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapterVinod mainAdapterVinod;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Event list layout
        setContentView(R.layout.activity_event_list);

        //floating action button in events main page
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        //Actions for floating button
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.bevents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Event_Model> options =
                new FirebaseRecyclerOptions.Builder<Event_Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Event Management"), Event_Model.class)
                        .build();

        mainAdapterVinod = new MainAdapterVinod(options);
        recyclerView.setAdapter(mainAdapterVinod);

    }


    //floating button action
    public void openNewActivity(){
        Intent intent = new Intent(this, VinodAdd.class);
        startActivity(intent);
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