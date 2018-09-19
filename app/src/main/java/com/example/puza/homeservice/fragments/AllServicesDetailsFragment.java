package com.example.puza.homeservice.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.homeservice.R;
import com.flaviofaria.kenburnsview.KenBurnsView;

public class AllServicesDetailsFragment extends Fragment {


    public AllServicesDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_services_details, container, false);

        KenBurnsView kbv = (KenBurnsView) view.findViewById(R.id.image_background);

        return view;
    }

}
