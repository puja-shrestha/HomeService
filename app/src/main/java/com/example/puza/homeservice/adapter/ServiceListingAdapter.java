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
import com.example.puza.homeservice.model.ServiceListingItems;

import java.util.List;

public class ServiceListingAdapter extends RecyclerView.Adapter<ServiceListingAdapter.MyViewHolder> {

    private List<ServiceListingItems> itemList;
    Activity context;

    public ServiceListingAdapter(Activity context, List<ServiceListingItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, price, perhour, day, description;
        private ImageView image;

        public MyViewHolder(View view) {
            super(view);

            image = (ImageView) view.findViewById(R.id.image);
            title = (TextView) view.findViewById(R.id.title);
            price = (TextView) view.findViewById(R.id.price);
            perhour = (TextView) view.findViewById(R.id.perhour);
            day = (TextView) view.findViewById(R.id.day);
            description = (TextView) view.findViewById(R.id.description);
        }
    }

    @Override
    public ServiceListingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_service_listing, parent, false);
        return new ServiceListingAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ServiceListingAdapter.MyViewHolder holder, final int position) {

        final ServiceListingItems items = itemList.get(position);
        holder.image.setImageResource(items.getImage());
        holder.title.setText(items.getTitle());
        holder.price.setText(items.getPrice());
        holder.perhour.setText(items.getPerhour());
        holder.day.setText(items.getDay());
        holder.description.setText(items.getDescription());

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

