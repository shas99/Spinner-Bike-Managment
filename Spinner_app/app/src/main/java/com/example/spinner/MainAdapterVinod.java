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

import de.hdodenhof.circleimageview.CircleImageView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainAdapterVinod extends FirebaseRecyclerAdapter<BikeRetreiveMainModel,MainAdapterVinod.myViewHolders> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapterVinod(@NonNull FirebaseRecyclerOptions<BikeRetreiveMainModel> options) {
        super(options);
    }

    @SuppressLint("RecyclerView")
    @Override
    protected void onBindViewHolder(@NonNull MainAdapterVinod.myViewHolders holder, int position, @NonNull BikeRetreiveMainModel model) {
        holder.Brand.setText(model.getBrand());
        holder.Name.setText(model.getName());
        holder.Origin.setText(model.getOrigin());

        Glide.with(holder.img.getContext())
                .load(model.getImage())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);


        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.activity_updates_popups))
                        .setExpanded(true,1150)
                        .create();

                //dialogPlus.show();

                view = dialogPlus.getHolderView();

                EditText Review = view.findViewById(R.id.txtNames);
                Button btnUpdate = view.findViewById(R.id.btnUpdates);


                Review.setText(model.getReview());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("Review",Review.getText().toString());

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
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.Brand.getContext());
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
                        Toast.makeText(holder.Brand.getContext(),"Cancelled!",Toast.LENGTH_SHORT).show();
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
        TextView Brand,Name,Origin;

        Button btnEdit,btnDelete;

        public myViewHolders(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView)itemView.findViewById(R.id.cham1vinod);
            Brand = (TextView)itemView.findViewById(R.id.nametextvinod);
            Name = (TextView) itemView.findViewById(R.id.nametext2vinod);
            Origin = (TextView) itemView.findViewById(R.id.nametext3vinod);

            btnEdit = (Button) itemView.findViewById(R.id.btnEditvinod);
            btnDelete = (Button) itemView.findViewById(R.id.btnDeletevinod);

        }
    }


}
