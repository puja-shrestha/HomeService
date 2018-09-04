package com.example.puza.homeservice.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.adapter.FeaturedServiceAdapter;
import com.example.puza.homeservice.adapter.ServiceListAdapter;
import com.example.puza.homeservice.model.FeaturedServiceItems;
import com.example.puza.homeservice.model.ServiceListItems;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

    /*---------------featured items----------------------*/
    RecyclerView serviceListRecyclerView;
    private RecyclerView.LayoutManager sLayoutManager;
    ServiceListAdapter serviceListAdapter;
    List<ServiceListItems> serviceListItems;
    /*---------------------------------------------------*/

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        /*------------------Service List Items--------------------------*/
        serviceListRecyclerView = (RecyclerView) view.findViewById(R.id.serviceListRecyclerView);

        serviceListItems = getserviceListItem();

        serviceListRecyclerView.setHasFixedSize(true);

        sLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        serviceListRecyclerView.setLayoutManager(sLayoutManager);
        serviceListAdapter = new ServiceListAdapter(getActivity(), serviceListItems);
        serviceListRecyclerView.setAdapter(serviceListAdapter);

        /*------------------------------------------------------------*/

        return view;
    }
    private List<ServiceListItems> getserviceListItem() {
        serviceListItems = new ArrayList<ServiceListItems>();

        serviceListItems.add(new ServiceListItems(R.drawable.plumber, "Home Deep Cleaning"));
        serviceListItems.add(new ServiceListItems(R.drawable.repair_mobile, "Home Basic Cleaning"));
        serviceListItems.add(new ServiceListItems(R.drawable.plumber1, "Tank Cleaning Service"));
        serviceListItems.add(new ServiceListItems(R.drawable.repair, "Pest Control Service"));
        serviceListItems.add(new ServiceListItems(R.drawable.plumber2, "On Demand Cleaner"));
        serviceListItems.add(new ServiceListItems(R.drawable.repairing, "Home Painting"));

        return serviceListItems;
    }
}
