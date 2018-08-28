package com.example.puza.homeservice.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.model.FeaturedServiceItems;
import com.example.puza.homeservice.model.PopularServiceItems;

import java.util.List;

public class PopularServiceAdapter extends RecyclerView.Adapter<PopularServiceAdapter.MyViewHolder> {

    private List<PopularServiceItems> itemList;
    Activity context;

    public PopularServiceAdapter(Activity context, List<PopularServiceItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, price;
        private ImageView image;


        public MyViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            image = (ImageView) view.findViewById(R.id.image);

        }
    }

    @Override
    public PopularServiceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_popular, parent, false);
        return new PopularServiceAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PopularServiceAdapter.MyViewHolder holder, final int position) {

        final PopularServiceItems items = itemList.get(position);
        holder.image.setImageResource(items.getImage());

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                transport("card");
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}

