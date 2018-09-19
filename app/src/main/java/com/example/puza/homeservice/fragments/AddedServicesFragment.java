package com.example.puza.homeservice.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.adapter.AddedServiceAdapter;
import com.example.puza.homeservice.model.AddedServiceItems;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AddedServicesFragment extends Fragment {

    /*---------------Added Service items----------------------*/
    RecyclerView addedServiceRecyclerView;
    private RecyclerView.LayoutManager addedLayoutManager;
    AddedServiceAdapter addedServicesAdapter;
    List<AddedServiceItems> addedServiceItems;
    /*---------------------------------------------------*/

    public AddedServicesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_added_services, container, false);

        Button btn_fav = (Button) view.findViewById(R.id.btn_fav);
        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new SweetAlertDialog(getContext(), SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Successfully Added!")
                        .setContentText("Your cart items has been successfully added to favorite list!")
                        .show();
            }
        });

        /*------------------Service List Items--------------------------*/
        addedServiceRecyclerView = (RecyclerView) view.findViewById(R.id.addedServicesRecyclerView);

        addedServiceItems = getAddedServiceItem();

        addedServiceRecyclerView.setHasFixedSize(true);

        addedLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        addedServiceRecyclerView.setLayoutManager(addedLayoutManager);
        addedServicesAdapter = new AddedServiceAdapter(getActivity(), addedServiceItems);
        addedServiceRecyclerView.setAdapter(addedServicesAdapter);

        /*------------------------------------------------------------*/
        return view;
    }
    private List<AddedServiceItems> getAddedServiceItem() {
        addedServiceItems = new ArrayList<AddedServiceItems>();

        addedServiceItems.add(new AddedServiceItems("Gadgets repair", "Approximate Price : NPR. 400"));
        addedServiceItems.add(new AddedServiceItems("Repairing", "Approximate Price : NPR. 900"));
        addedServiceItems.add(new AddedServiceItems("Mobile Repair", "Approximate Price : NPR. 400"));
        addedServiceItems.add(new AddedServiceItems("Car Rental", "Approximate Price : NPR. 700"));
        addedServiceItems.add(new AddedServiceItems("Plumbing", "Approximate Price : NPR. 300"));

        return addedServiceItems;
    }

}
