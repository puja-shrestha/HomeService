package com.example.puza.homeservice.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.fragments.services.AllServicesFragment;
import com.example.puza.homeservice.model.ServiceItems;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.MyViewHolder> {

    private List<ServiceItems> itemList;
    Activity context;
    ProgressDialog  progressDialog;

    public ServiceAdapter(Activity context, List<ServiceItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private CircleImageView image;

        public MyViewHolder(View view) {
            super(view);

            image = (CircleImageView) view.findViewById(R.id.image);
            name = (TextView) view.findViewById(R.id.name);

            image.setOnClickListener(new View.OnClickListener() {
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
                                Thread.sleep(2000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();

                            AllServicesFragment fragment = new AllServicesFragment();
                            FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame_container, fragment);
                            transaction.commit();
                        }
                    }).start();
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_service, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final ServiceItems items = itemList.get(position);
        holder.image.setImageResource(items.getImage());
        holder.name.setText(items.getName());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
