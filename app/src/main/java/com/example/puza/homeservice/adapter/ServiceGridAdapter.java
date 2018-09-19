package com.example.puza.homeservice.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.puza.homeservice.R;
import com.example.puza.homeservice.fragments.services.AllServicesFragment;
import com.example.puza.homeservice.model.Service;

import java.util.List;

public class ServiceGridAdapter extends RecyclerView.Adapter<ServiceGridAdapter.MyViewHolder> {

    private Context context;
    ProgressDialog  progressDialog;
    private List<Service> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            title =(TextView) itemView.findViewById(R.id.title);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);

            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage("Loading..."); // Setting Message
                    progressDialog.setTitle("Please wait"); // Setting Title
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                    progressDialog.show(); // Display Progress Dialog
                    progressDialog.setCancelable(false);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();

                            AllServicesFragment fragment = new AllServicesFragment();
                            FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame_container, fragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                    }).start();
                }
            });
        }
    }

    public ServiceGridAdapter(Context mContext, List<Service> albumList) {
        this.context = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_service_grid, parent, false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final ServiceGridAdapter.MyViewHolder holder, int position) {
        Service album = albumList.get(position);
        holder.title.setText(album.getName());

        //locating album cover using glide library
        Glide.with(context).load(album.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
