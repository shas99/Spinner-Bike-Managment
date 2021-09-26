package com.example.spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.UUID;

public class UserFeedback extends AppCompatActivity {

    //Init Assets
    private EditText mName ,mDesc;
    private Button mSavebtn,mShowbtn;
    private FirebaseFirestore db;
    private String uName,uDesc,uId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_feedback);


        //Layouts hooks
        mName = findViewById(R.id.edit_name);
        mDesc=findViewById(R.id.edit_desc);
        mSavebtn=findViewById(R.id.savebtn);
        mShowbtn=findViewById(R.id.showBtn);
        db =FirebaseFirestore.getInstance();


        Bundle bundle =getIntent().getExtras();
        if(bundle !=null){
            mSavebtn.setText("Update");
            uName =bundle.getString("uName");
            uId =bundle.getString("uId");
            uDesc=bundle.getString("uDesc");

            mName.setText(uName);
            mDesc.setText(uDesc);

        }else{
            mSavebtn.setText("Save");
        }


        //Handle function -> showTask()
        mShowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change me later
                startActivity(new Intent(UserFeedback.this,ShowActivity.class));
            }
        });

        //Handle function -> saveTask()
        mSavebtn.setOnClickListener(new View.OnClickListener() {


@Override
public void onClick(View v) {
                String name = mName.getText().toString();
                String desc =mDesc.getText().toString();

                Bundle bundle1 = getIntent().getExtras();
                if(bundle1 !=null){
                    String id = uId;
                    updateToFireStore(id,name,desc);
                }else{
                    String id = UUID.randomUUID().toString();
                    saveToFireStore(id , name,desc);
                }
            }


        });

    }


private void updateToFireStore(String id,String name,String desc){
        db.collection("User Feedback").document(id).update("name",name,"desc",desc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull  Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(UserFeedback.this, "Data Updated", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(UserFeedback.this, "Error Updating"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull  Exception e) {
                Toast.makeText(UserFeedback.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

private void saveToFireStore(String id,String name ,String desc){

        if(!name.isEmpty() && !desc.isEmpty()){

            HashMap<String,Object> map =new HashMap<>();
            map.put("id",id);
            map.put("name",name);
            map.put("desc",desc);

            db.collection("User Feedback" ).document(id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(UserFeedback.this, "Data Saved !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(UserFeedback.this, "Failed To Store Data"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


        }else{
            Toast.makeText(this, "Empty Fields not Allowed !", Toast.LENGTH_SHORT).show();
        }


    }
}