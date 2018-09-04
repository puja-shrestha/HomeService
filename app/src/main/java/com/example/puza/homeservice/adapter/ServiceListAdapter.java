package com.example.puza.homeservice.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.model.ServiceListItems;

import java.util.List;

public class ServiceListAdapter extends RecyclerView.Adapter<ServiceListAdapter.MyViewHolder> {

    private List<ServiceListItems> itemList;
    Activity context;

    public ServiceListAdapter(Activity context, List<ServiceListItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView image;


        public MyViewHolder(View view) {
            super(view);

            image = (ImageView) view.findViewById(R.id.image_background);
            title = (TextView) view.findViewById(R.id.textViewBottom);
        }
    }

    @Override
    public ServiceListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_service_list, parent, false);
        return new ServiceListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ServiceListAdapter.MyViewHolder holder, final int position) {

        final ServiceListItems items = itemList.get(position);
        holder.image.setImageResource(items.getbImage());
        holder.title.setText(items.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

}
