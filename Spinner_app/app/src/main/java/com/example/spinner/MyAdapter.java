package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    //Init Assets
    private ShowActivity activity;
    private List<Model> mList;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


public MyAdapter(ShowActivity activity,List<Model> mList){
        this.activity=activity;
        this.mList =mList;

    }

//Update Tasks
public void updateData(int position) {
    Model item = mList.get(position);
    Bundle bundle = new Bundle();
    bundle.putString("uId", item.getId());
    bundle.putString("uName", item.getName());
    bundle.putString("uDesc", item.getDesc());
    Intent intent = new Intent(activity, UserFeedback.class);
    intent.putExtras(bundle);
    activity.startActivity(intent);

}

//Delete Task
public void deleteData(int position){

        Model item = mList.get(position);
        db.collection("User Feedback").document(item.getId()).delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull  Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(activity, "Data Deleted", Toast.LENGTH_SHORT).show();
                            notifyRemoved(position);
                        }else{
                            Toast.makeText(activity, "Error "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

private void notifyRemoved(int position){
        mList.remove(position);
        notifyItemRemoved(position);
        activity.showData();
    }


@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(activity).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.name.setText(mList.get(position).getName());
        holder.desc.setText(mList.get(position).getDesc());

    }


    //Count Tasks
    @Override
public int getItemCount() {
        return mList.size();
    }

public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,desc;

    public MyViewHolder(@NonNull View itemView){
            super(itemView);
            name =itemView.findViewById(R.id.name_text);
            desc =itemView.findViewById(R.id.desc_text);
        }
    }

}