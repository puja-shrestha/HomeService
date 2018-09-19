package com.example.puza.homeservice.fragments.services;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.adapter.AllServicesAdapter;
import com.example.puza.homeservice.model.AllServiceItems;

import java.util.ArrayList;
import java.util.List;

public class Tab6 extends Fragment {

    /*---------------featured items----------------------*/
    RecyclerView allServiceRecyclerView;
    private RecyclerView.LayoutManager asLayoutManager;
    AllServicesAdapter allServicesAdapter;
    List<AllServiceItems> allServiceItems;
    /*---------------------------------------------------*/


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service_types, container, false);

        /*------------------Service List Items--------------------------*/
        allServiceRecyclerView = (RecyclerView) view.findViewById(R.id.serviceListingRecyclerView);

        allServiceItems = getAllServiceItem();

        allServiceRecyclerView.setHasFixedSize(true);

        asLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        allServiceRecyclerView.setLayoutManager(asLayoutManager);
        allServicesAdapter = new AllServicesAdapter(getActivity(), allServiceItems);
        allServiceRecyclerView.setAdapter(allServicesAdapter);

        /*------------------------------------------------------------*/
        return view;
    }

    private List<AllServiceItems> getAllServiceItem() {
        allServiceItems = new ArrayList<AllServiceItems>();

        allServiceItems.add(new AllServiceItems(R.drawable.repairing, "Desktop Services"));
        allServiceItems.add(new AllServiceItems(R.drawable.repair, "Laptop Servicing"));
        allServiceItems.add(new AllServiceItems(R.drawable.plumber2, "Display Services"));
        allServiceItems.add(new AllServiceItems(R.drawable.plumber, "Apple Product Servicing"));
        allServiceItems.add(new AllServiceItems(R.drawable.repair_mobile, "CCTV Camera Services & Repair"));
        allServiceItems.add(new AllServiceItems(R.drawable.plumber3, "Access Control Services"));
        allServiceItems.add(new AllServiceItems(R.drawable.repairing, "Internet Network Services"));

        //        allServiceItems.add(new AllServiceItems(R.drawable.repair, "Home Basic Cleaning"));
//        allServiceItems.add(new AllServiceItems(R.drawable.plumber2, "Tank Cleaning Service"));
//        allServiceItems.add(new AllServiceItems(R.drawable.plumber, "On Demand Cleaner"));
//        allServiceItems.add(new AllServiceItems(R.drawable.repair_mobile, "Home Painting"));
//        allServiceItems.add(new AllServiceItems(R.drawable.plumber3, "Home Deep Cleaning"));
//
//        allServiceItems.add(new AllServiceItems(R.drawable.repair, "Home Basic Cleaning"));
//        allServiceItems.add(new AllServiceItems(R.drawable.plumber2, "Tank Cleaning Service"));
//        allServiceItems.add(new AllServiceItems(R.drawable.plumber, "On Demand Cleaner"));
//        allServiceItems.add(new AllServiceItems(R.drawable.repair_mobile, "Home Painting"));
//        allServiceItems.add(new AllServiceItems(R.drawable.plumber3, "Home Deep Cleaning"));

        return allServiceItems;
    }

}
