package com.example.spinner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

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
    protected void onBindViewHolder(@NonNull myViewHolders holder, int position, @NonNull BikeRetreiveMainModel model) {
        holder.Brand.setText(model.getBrand());
        holder.Name.setText(model.getName());
        holder.Origin.setText(model.getOrigin());

        Glide.with(holder.img.getContext())
                .load(model.getImage())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);
    }

    @NonNull
    @Override
    public myViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_chamath_retreive,parent,false);

        return new myViewHolders(view);
    }

    class myViewHolders extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView Brand,Name,Origin;

        public myViewHolders(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView)itemView.findViewById(R.id.cham1);
            Brand = (TextView)itemView.findViewById(R.id.nametext);
            Name = (TextView) itemView.findViewById(R.id.nametext2);
            Origin = (TextView) itemView.findViewById(R.id.nametext3);

        }
    }

}
