package com.example.puza.homeservice.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.adapter.SeeAllServicesAdapter;
import com.example.puza.homeservice.model.SeeAllServiceItems;

import java.util.ArrayList;
import java.util.List;

public class ServicesAddFragment extends Fragment {

    /*---------------see all services----------------------*/
    RecyclerView seeAllServiceRecyclerView;
    private RecyclerView.LayoutManager seeAllLayoutManager;
    SeeAllServicesAdapter seeAllServicesAdapter;
    List<SeeAllServiceItems> seeAllServiceItems;
    /*---------------------------------------------------*/

    public ServicesAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services_add, container, false);

        /*------------------see all service List --------------------------*/
        seeAllServiceRecyclerView = (RecyclerView) view.findViewById(R.id.seeAllRecyclerView);

        seeAllServiceItems = getSeeAllServiceItem();

        seeAllServiceRecyclerView.setHasFixedSize(true);

        seeAllLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        seeAllServiceRecyclerView.setLayoutManager(seeAllLayoutManager);
        seeAllServicesAdapter = new SeeAllServicesAdapter(getActivity(), seeAllServiceItems);
        seeAllServiceRecyclerView.setAdapter(seeAllServicesAdapter);

        /*------------------------------------------------------------*/
        return view;
    }

    private List<SeeAllServiceItems> getSeeAllServiceItem() {
        seeAllServiceItems = new ArrayList<SeeAllServiceItems>();

        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repairing, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repair_mobile, "Mobile Check Up","Mobile Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber, "Plumbing","Plumbing service","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber3, "Home Appliance","Home Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repair, "Car Rental","Car Rental","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber1, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repairing, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber2, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repair_mobile, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber1, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repair_mobile, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repairing, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber3, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber2, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repair_mobile, "AC Check Up","Ac Service and Repair","ADD","VIEW DETAILS..."));


        return seeAllServiceItems;
    }

}
