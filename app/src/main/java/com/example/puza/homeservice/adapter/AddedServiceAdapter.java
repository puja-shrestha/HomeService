package com.example.puza.homeservice.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.fragments.services.Tab3;
import com.example.puza.homeservice.model.AddedServiceItems;

import java.util.List;

public class AddedServiceAdapter extends RecyclerView.Adapter<AddedServiceAdapter.MyViewHolder> {

    private List<AddedServiceItems> itemList;
    ProgressDialog progressDialog;
    Activity context;

    public AddedServiceAdapter(Activity context, List<AddedServiceItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView addedServicesTitle;
        private TextView addedServicesSubTitle;
        private LinearLayout linearAddedService;

        public MyViewHolder(View view) {
            super(view);

            addedServicesTitle = (TextView) view.findViewById(R.id.addedServiceTitle);
            addedServicesSubTitle = (TextView) view.findViewById(R.id.addedServiceSubTitle);

            linearAddedService = (LinearLayout)view.findViewById(R.id.linearAddedService);
            linearAddedService.setOnClickListener(new View.OnClickListener() {
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

                            Tab3 fragment = new Tab3();
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

    @Override
    public AddedServiceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_added_services, parent, false);
        return new AddedServiceAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AddedServiceAdapter.MyViewHolder holder, final int position) {

        final AddedServiceItems items = itemList.get(position);
        holder.addedServicesTitle.setText(items.getAddedServicesTitle());
        holder.addedServicesSubTitle.setText(items.getAddedServicesSubTitle());

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

