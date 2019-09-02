package com.fabricmonde.salesapp.traceadapter;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.fabricmonde.salesapp.R;
import com.fabricmonde.salesapp.details.DetailsActivity;
import com.fabricmonde.salesapp.tracemodel.item_header_model;

import java.util.ArrayList;


public class item_header_adapter extends RecyclerView.Adapter<item_header_adapter.ViewHolder> {

    Context context;
    ArrayList<item_header_model>model;
    Activity activity;

    public item_header_adapter(Context context, ArrayList<item_header_model> model, Activity cunt) {
        this.context = context;
        this.model = model;
        this.activity=cunt;
    }

    @NonNull
    @Override
    public item_header_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull item_header_adapter.ViewHolder holder, int position) {

        holder.image.setImageResource(model.get(position).getImage1());
        holder.tv1.setText(model.get(position).getTv1());
        holder.tv2.setText(model.get(position).getTv2());
        holder.tv3.setText(model.get(position).getTv3());
        holder.rootholder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("WOWOW", "onClick:");


                DetailsActivity.start(activity,
                        model.get(position).getTv1(),model.get(position).getTv3() , "https://fabricmonde-web-files.s3.amazonaws.com/sales-app/CottonConnect1.PNG", holder.rootholder);

            }
        });

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tv1,tv2,tv3;
        CardView rootholder;
        View content;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.header_image);
            rootholder = itemView.findViewById(R.id.rootholder);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }
}
