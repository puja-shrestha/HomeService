package com.example.puza.homeservice.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.model.FeaturedServiceItems;

import java.util.List;

public class FeaturedServiceAdapter extends RecyclerView.Adapter<FeaturedServiceAdapter.MyViewHolder> {

    private List<FeaturedServiceItems> itemList;
    Activity context;

    public FeaturedServiceAdapter(Activity context, List<FeaturedServiceItems> itemList) {
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
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_featured_service, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        final FeaturedServiceItems items = itemList.get(position);
        holder.image.setImageResource(items.getImage());
        holder.name.setText(items.getName());

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


//    private void transport(String fragmentName){
//        fragment = null;
//        FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
//
//        switch (fragmentName) {
//            case "card":
//
//                progressDialog = new ProgressDialog(context);
//                progressDialog.setMessage("Loading..."); // Setting Message
//                progressDialog.setTitle("Please wait"); // Setting Title
//                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
//                progressDialog.show(); // Display Progress Dialog
//                progressDialog.setCancelable(false);
//
//                new Thread(new Runnable() {
//                    public void run() {
//                        try {
//                            Thread.sleep(2000);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        progressDialog.dismiss();
//                    }
//                }).start();
//
//                fragment = new ShopItemsFragment();
//                break;
//        }
//
//        if (fragment != null){
//            fragmentManager.beginTransaction().replace(R.id.frame_container,fragment).addToBackStack(null).commit();
//        }
//    }

}
