package com.example.spinner;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainAdapterChamath extends FirebaseRecyclerAdapter <BikeRetreiveMainModel,MainAdapterChamath.myViewHolders>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapterChamath(@NonNull FirebaseRecyclerOptions<BikeRetreiveMainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolders holder, @SuppressLint("RecyclerView") int position, @NonNull BikeRetreiveMainModel model) {
        //Local variables are connected with the database
        holder.Brand.setText(model.getBrand());
        holder.Name.setText(model.getName());
        holder.Origin.setText(model.getOrigin());




        //Glide dependency image connection
        Glide.with(holder.img.getContext())
                .load(model.getImage())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

        //Calculations
        String[] date = Calendar.getInstance().getTime().toString().split(" ");
        String Day = date[2];
        String Month = date[1];
        String Year = date[5];
        int months = 0;

        holder.Return.setText(model.getLease());

        switch(Month){
            case "Jan":
                months = 1;
                break;
            case "Feb":
                months = 2;
                break;
            case "Mar":
                months = 3;
                break;
            case "Apr":
                months = 4;
                break;
            case "May":
                months = 5;
                break;
            case "Jun":
                months = 6;
                break;
            case "Jul":
                months = 7;
                break;
            case "Aug":
                months = 8;
                break;
            case "Sep":
                months = 9;
                break;
            case "Oct":
                months = 10;
                break;
            case "Nov":
                months = 11;
                break;
            case "Dec":
                months = 12;
                break;
        }

        if(months+Integer.parseInt(model.getLease()) > 12){

            String LeasingDate;

            int ret = Integer.parseInt(model.getLease())-(12 - months);
            LeasingDate = model.getDay()+"/"+String.valueOf(ret)+"/"+String.valueOf(Integer.parseInt(model.getYear())+1);
            holder.Return.setText((LeasingDate));
            System.out.println("This the ret "+ret);

        }else{

            String LeasingDate;

            int ret = Integer.parseInt(model.getLease())+(months);
            LeasingDate = model.getDay()+"/"+String.valueOf(ret)+"/"+Year;
            holder.Return.setText((LeasingDate));

        }




        // Update
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initializing the update popup
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.activity_updates_popups))
                        .setExpanded(true,1150)
                        .create();

                //dialogPlus.show();

                view = dialogPlus.getHolderView();
                // Inputs are obtained from the popup for editing
                EditText Review = view.findViewById(R.id.txtNames);
                Button btnUpdate = view.findViewById(R.id.btnUpdates);

                //Setting the inputs utilizing the model class
                Review.setText(model.getReview());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("Review",Review.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Bicycle Management")
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

        //Delete
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.Brand.getContext());
                builder.setTitle("Do you wish to proceed with deletion?");
                builder.setMessage("Deletions cannot be reversed!");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Bicycle Management")
                                .child(Objects.requireNonNull(getRef(position).getKey())).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.Brand.getContext(),"Cancelled!",Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public myViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_chamath_retreive,parent,false);

        return new myViewHolders(view);
    }

    static class myViewHolders extends RecyclerView.ViewHolder{
        //Images and text views
        CircleImageView img;
        TextView Brand,Name,Origin,Review,Return;
        //Buttons
        Button btnEdit,btnDelete;

        //Connection of the respective UI layout components
        public myViewHolders(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView)itemView.findViewById(R.id.cham1);
            Brand = (TextView)itemView.findViewById(R.id.nametext);
            Name = (TextView) itemView.findViewById(R.id.nametext2);
            Origin = (TextView) itemView.findViewById(R.id.nametext3);
            Review = (TextView) itemView.findViewById(R.id.txtNames);


            btnEdit = (Button) itemView.findViewById(R.id.btnEdit);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);

            Return = (TextView) itemView.findViewById(R.id.textLease);

        }
    }

}
