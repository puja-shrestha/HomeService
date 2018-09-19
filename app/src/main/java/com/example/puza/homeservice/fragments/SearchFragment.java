package com.example.puza.homeservice.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.adapter.ServiceListAdapter;
import com.example.puza.homeservice.adapter.ServiceListingAdapter;
import com.example.puza.homeservice.model.ServiceListItems;
import com.example.puza.homeservice.model.ServiceListingItems;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    /*---------------featured items----------------------*/
    RecyclerView serviceListingRecyclerView;
    private RecyclerView.LayoutManager slLayoutManager;
    ServiceListingAdapter serviceListingAdapter;
    List<ServiceListingItems> serviceListingItems;
    /*---------------------------------------------------*/

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        /*------------------Service List Items--------------------------*/
        serviceListingRecyclerView = (RecyclerView) view.findViewById(R.id.serviceListingRecyclerView);

        serviceListingItems = getServiceListingItem();

        serviceListingRecyclerView.setHasFixedSize(true);

        slLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        serviceListingRecyclerView.setLayoutManager(slLayoutManager);
        serviceListingAdapter = new ServiceListingAdapter(getActivity(), serviceListingItems);
        serviceListingRecyclerView.setAdapter(serviceListingAdapter);

        /*------------------------------------------------------------*/

        return view;
    }

    private List<ServiceListingItems> getServiceListingItem() {
        serviceListingItems = new ArrayList<ServiceListingItems>();

        serviceListingItems.add(new ServiceListingItems(R.drawable.repairing, "Home Deep Cleaning", "Nrs. 500", "(Per hour)","Takes 1 day", "Decoration hand made bag by rudrakshaya's.Decoration hand made."));
        serviceListingItems.add(new ServiceListingItems(R.drawable.repair, "Home Basic Cleaning","Nrs. 500","(Per hour)","Takes 1 day","Decoration hand made bag by rudrakshaya's.Decoration hand made."));
        serviceListingItems.add(new ServiceListingItems(R.drawable.plumber2, "Tank Cleaning Service", "Nrs. 500","(Per hour)","Takes 1 day","Decoration hand made bag by rudrakshaya's.Decoration hand made."));
        serviceListingItems.add(new ServiceListingItems(R.drawable.plumber, "On Demand Cleaner","Nrs. 500","(Per hour)","Takes 1 day","Decoration hand made bag by rudrakshaya's.Decoration hand made."));
        serviceListingItems.add(new ServiceListingItems(R.drawable.repair_mobile, "Home Painting","Nrs. 500","(Per hour)","Takes 1 day","Decoration hand made bag by rudrakshaya's.Decoration hand."));
        serviceListingItems.add(new ServiceListingItems(R.drawable.plumber3, "Home Deep Cleaning", "Nrs. 500", "(Per hour)","Takes 1 day", "Decoration hand made bag by rudrakshaya's.Decoration."));
        serviceListingItems.add(new ServiceListingItems(R.drawable.plumber1, "Home Basic Cleaning","Nrs. 500","(Per hour)","Takes 1 day","Decoration hand made bag by rudrakshaya's.Decoration hand."));

        return serviceListingItems;
    }

}
