package com.example.puza.homeservice.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.model.TrendingServiceItems;

import java.util.List;

public class TrendingServiceAdapter extends RecyclerView.Adapter<TrendingServiceAdapter.MyViewHolder> {

    private List<TrendingServiceItems> itemList;
    Activity context;

    public TrendingServiceAdapter(Activity context, List<TrendingServiceItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title, subtitle, price;


        public MyViewHolder(View view) {
            super(view);

            image = (ImageView) view.findViewById(R.id.image);
            title = (TextView) view.findViewById(R.id.title);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            price = (TextView) view.findViewById(R.id.price);

        }
    }

    @Override
    public TrendingServiceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_trending, parent, false);
        return new TrendingServiceAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TrendingServiceAdapter.MyViewHolder holder, final int position) {

        final TrendingServiceItems items = itemList.get(position);

        holder.image.setImageResource(items.getImage());
        holder.title.setText(items.getTitle());
        holder.subtitle.setText(items.getSubtitle());
        holder.price.setText(items.getPrice());

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




