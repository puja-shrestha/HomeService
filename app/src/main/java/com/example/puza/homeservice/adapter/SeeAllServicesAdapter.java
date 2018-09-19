package com.example.puza.homeservice.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.fragments.AddedServicesFragment;
import com.example.puza.homeservice.fragments.AllServicesDetailsFragment;
import com.example.puza.homeservice.model.SeeAllServiceItems;

import java.util.List;

public class SeeAllServicesAdapter extends RecyclerView.Adapter<SeeAllServicesAdapter.MyViewHolder> {

    private List<SeeAllServiceItems> itemList;
    ProgressDialog  progressDialog;
    Activity context;

    public SeeAllServicesAdapter(Activity context, List<SeeAllServiceItems> itemList) {
            this.itemList = itemList;
            this.context = context;
            }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView seeAllServicesTitle, viewDetail;
        private ImageView seeAllServicesImage;
        private TextView seeAllServicesSubtitle;
        private Button seeAllServicesButton;
//        private CardView seeAllServicesCard;

        public MyViewHolder(View view) {
            super(view);

            seeAllServicesImage = (ImageView) view.findViewById(R.id.seeAllServicesImage);
            seeAllServicesTitle = (TextView) view.findViewById(R.id.seeAllServicesTitle);
            seeAllServicesSubtitle = (TextView) view.findViewById(R.id.subtitle);

            viewDetail = (TextView) view.findViewById(R.id.seeAllServicesViewDetail);
//            SpannableString content = new SpannableString("VIEW DETAILS...");
//            content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
//            viewDetail.setText(content);

            viewDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                AllServicesDetailsFragment fragment = new AllServicesDetailsFragment();
//                FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.frame_container, fragment);
//                transaction.commit();

                    // Create custom dialog object
                    final Dialog dialog = new Dialog(context);
                    // Include dialog.xml file
                    dialog.setContentView(R.layout.fragment_all_services_details);

                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

                    // Set dialog title
                    TextView detail = (TextView)dialog.findViewById(R.id.detail);
                    FrameLayout frame = (FrameLayout)dialog.findViewById(R.id.frame);

                    // set values for custom dialog components - text, image and button
                    TextView text1 = (TextView) dialog.findViewById(R.id.text1);
                    dialog.show();
                }
            });



//            seeAllServicesButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    v.setSelected(true);
////                  transportTo("service");
//                }
//            });

            seeAllServicesButton = (Button) view.findViewById(R.id.seeAllServicesBtn);
            seeAllServicesButton.setOnClickListener(new View.OnClickListener() {
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
                                Thread.sleep(500);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();

                            AddedServicesFragment fragment = new AddedServicesFragment();
                            FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame_container, fragment);
                            transaction.addToBackStack(null);
                            transaction.commit();

//                            AddedServicesFragment home = new AddedServicesFragment();
//                            FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
//                            manager.beginTransaction().add(R.id.frame_container, home).commit();
                        }
                    }).start();
                }
            });

        }
    }

        @Override
        public SeeAllServicesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.items_see_all_services, parent, false);
            return new SeeAllServicesAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(SeeAllServicesAdapter.MyViewHolder holder, final int position) {

            final SeeAllServiceItems items = itemList.get(position);
            holder.seeAllServicesImage.setImageResource(items.getSeeAllServicesImage());
            holder.seeAllServicesTitle.setText(items.getSeeAllServicesTitle());
            holder.seeAllServicesSubtitle.setText(items.getSeeAllServicesSubtitle());
            holder.seeAllServicesButton.setText(items.getSeeAllServicesButton());
            holder.viewDetail.setText(items.getViewDetails());
        }

        @Override
        public int getItemCount() {
            return this.itemList.size();
        }

    }


