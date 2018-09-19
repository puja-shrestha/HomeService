package com.example.puza.homeservice.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.fragments.ServiceDetailFragment;
import com.example.puza.homeservice.model.AllServiceItems;

import java.util.List;

public class AllServicesAdapter extends RecyclerView.Adapter<AllServicesAdapter.MyViewHolder> {

    private List<AllServiceItems> itemList;
    ProgressDialog  progressDialog;
    Activity context;

    public AllServicesAdapter(Activity context, List<AllServiceItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView allServicesTitle;
        private ImageView allServicesImage;
        private CardView allServicesCard;

        public MyViewHolder(View view) {
            super(view);

            allServicesImage = (ImageView) view.findViewById(R.id.allServicesImage);
            allServicesTitle = (TextView) view.findViewById(R.id.allServicesTitle);
            allServicesCard = (CardView) view.findViewById(R.id.allServicesCard);

            allServicesCard.setOnClickListener(new View.OnClickListener() {
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

                            ServiceDetailFragment fragment = new ServiceDetailFragment();
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
    public AllServicesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_all_services, parent, false);
        return new AllServicesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AllServicesAdapter.MyViewHolder holder, final int position) {

        final AllServiceItems items = itemList.get(position);
        holder.allServicesImage.setImageResource(items.getAllServicesImage());
        holder.allServicesTitle.setText(items.getAllServicesTitle());

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

