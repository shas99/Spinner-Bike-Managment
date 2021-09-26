package com.example.spinner;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainAdapterVinod extends FirebaseRecyclerAdapter<Event_Model,MainAdapterVinod.myViewHolders> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapterVinod(@NonNull FirebaseRecyclerOptions<Event_Model> options) {
        super(options);
    }

    @SuppressLint("RecyclerView")
    @Override
    protected void onBindViewHolder(@NonNull MainAdapterVinod.myViewHolders holder, int position, @NonNull Event_Model model) {
        holder.Name.setText(model.getname());
        holder.Start.setText(model.getStart());
        holder.End.setText(model.getEnd());
        holder.Web.setText(model.getWeb());
        holder.Status.setText(model.getStatus());



        Glide.with(holder.img.getContext())
                .load(model.getBanner())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);
        String[] date = Calendar.getInstance().getTime().toString().split(" ");
        String Day = date[2];
        String Month = date[1];
        String Year = date[5];
        String[] eventDate = holder.Start.getText().toString().split("/");
        int howlong = 0;
        int monthd =0;


        System.out.println("****" + eventDate[1]+"****");
        System.out.println("****" + Month +"****");

       switch(Month){
           case "Jan":
               monthd = 1;
               break;
           case "Feb":
               monthd = 2;
               break;
           case "Mar":
               monthd = 3;
               break;
           case "Apr":
               monthd = 4;
               break;
           case "May":
               monthd = 5;
               break;
           case "Jun":
               monthd = 6;
               break;
           case "Jul":
               monthd = 7;
               break;
           case "Aug":
               monthd = 8;
               break;
           case "Sep":
               monthd = 9;
               break;
           case "Oct":
               monthd = 10;
               break;
           case "Nov":
               monthd = 11;
               break;
           case "Dec":
               monthd = 12;
               break;
       }
        System.out.println("*********" + monthd +"****");

        if(Integer.parseInt(Year) == Integer.parseInt(eventDate[2])){
            if(monthd == Integer.parseInt(eventDate[1])){
                int temp = Integer.parseInt(eventDate[0]) - Integer.parseInt(Day);
//                holder.Remaining.setText(String.valueOf(eventDate[1]));
              holder.Remaining.setText(String.valueOf(temp));
                //holder.Remaining.setText(String.valueOf(Integer.parseInt(eventDate[0]) -Integer.parseInt(Day)));
            }else if(monthd+1 == Integer.parseInt(eventDate[1])){
                int temp = 30-Integer.parseInt(Day);
                temp = temp + Integer.parseInt(eventDate[0]);
                holder.Remaining.setText(String.valueOf(temp));
            }else{
                int temp = Integer.parseInt(eventDate[1]) - monthd * 30;
                temp += Integer.parseInt(eventDate[0]);
                holder.Remaining.setText(String.valueOf(temp));
            }

        }else if(Integer.parseInt(Year)+1 == Integer.parseInt(eventDate[2])){
            int temp =(30-Integer.parseInt(Day))+(12 - monthd)*30 + (Integer.parseInt(eventDate[1])-1)*30 +Integer.parseInt(eventDate[0]);
            System.out.println("******************"+Integer.parseInt(String.valueOf(30-Integer.parseInt(Day))));
            holder.Remaining.setText(String.valueOf(temp));
        }

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.activity_status_update_popup))
                        .setExpanded(true,1150)
                        .create();

                //dialogPlus.show();

                view = dialogPlus.getHolderView();

                EditText Review = view.findViewById(R.id.txtNames123);
                Button btnUpdate = view.findViewById(R.id.btnUpdates123);


                Review.setText(model.getStatus());

                dialogPlus.show();


                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("status",Review.getText().toString());


                        FirebaseDatabase.getInstance().getReference().child("Event Management")
                                .child(Objects.requireNonNull(getRef(position).getKey())).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        //Toast.makeText(Review.getContext(),"Updated Successfully",Toast.LENGTH_SHORT).show();
                                        Toast.makeText(Review.getContext(),"Update Successful!",Toast.LENGTH_SHORT).show();

                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(Exception e) {
                                        Toast.makeText(Review.getContext(),"Error While Updating",Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });




            }
        });


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.Name.getContext());
                builder.setTitle("Do you wish to proceed with deletion?");
                builder.setMessage("Deletions cannot be reversed!");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Event Management")
                                .child(Objects.requireNonNull(getRef(position).getKey())).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.Name.getContext(),"Cancelled!",Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        });


    }



    @NonNull
    @Override
    public MainAdapterVinod.myViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_vinod_retreive,parent,false);

        return new MainAdapterVinod.myViewHolders(view);
    }

    class myViewHolders extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView Name,Start,End,Web,Status,Remaining;

        Button btnEdit,btnDelete;

        public myViewHolders(@NonNull View itemView) {
            super(itemView);

            Remaining = (TextView) itemView.findViewById(R.id.RemainingTxt546);
            img = (CircleImageView)itemView.findViewById(R.id.cham1vinod);
            Name = (TextView)itemView.findViewById(R.id.nametextvinod);
            Start = (TextView) itemView.findViewById(R.id.nametext2vinod);
            End = (TextView) itemView.findViewById(R.id.nametext2vinod1);
            Web = (TextView) itemView.findViewById(R.id.nametext3vinod);
            Status = (TextView) itemView.findViewById(R.id.nametext3vinod145);

            btnEdit = (Button) itemView.findViewById(R.id.btnEditvinod);
            btnDelete = (Button) itemView.findViewById(R.id.btnDeletevinod);

        }
    }


}
