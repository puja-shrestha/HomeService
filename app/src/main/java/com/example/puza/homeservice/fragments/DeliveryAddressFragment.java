package com.example.puza.homeservice.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.activity.MapsActivity;

public class DeliveryAddressFragment extends Fragment {

    Button add_new_address, checkout;
    Dialog dialog;

    public DeliveryAddressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery_address, container, false);

        add_new_address = (Button)view.findViewById(R.id.add_new_address);

        checkout = (Button)view.findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckoutFragment fragment = new CheckoutFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        openAddressDialogue();

        return view;
    }

    public void openAddressDialogue(){

        // add listener to button
        add_new_address.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Create custom dialog object
                dialog = new Dialog(getContext());
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialogue_address_template);
                // Set dialog title
                TextView txt1 = (TextView)dialog.findViewById(R.id.txt1);
                dialog.setTitle("Add New Address");

                // set values for custom dialog components - text, image and button
                TextView txt2 = (TextView) dialog.findViewById(R.id.txt2);
                txt2.setText("Why take hassel ? Simply click below and let us take care of the rest!");

                EditText editText = (EditText)dialog.findViewById(R.id.editTextAddress);

                dialog.show();

                Button pinBtn = (Button) dialog.findViewById(R.id.pinBtn);
                pinBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(getActivity(), MapsActivity.class);
                        startActivity(i);

//                      ((Activity) getActivity()).overridePendingTransition(0,0);

//                        MapsFragment fragment = new MapsFragment();
//                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                        transaction.replace(R.id.frame_container, fragment);
//                        transaction.addToBackStack(null);
//                        transaction.commit();

                    }
                });

                Button declineButton = (Button) dialog.findViewById(R.id.btn_dialogue);
                // if decline button is clicked, close the custom dialog
                declineButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Close dialog
                        dialog.dismiss();
                    }
                });
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

}
