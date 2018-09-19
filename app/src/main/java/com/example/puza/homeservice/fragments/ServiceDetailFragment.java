package com.example.puza.homeservice.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.adapter.TrendingServiceAdapter;
import com.example.puza.homeservice.model.TrendingServiceItems;
import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.ArrayList;
import java.util.List;

public class ServiceDetailFragment extends Fragment {

    private Button button;
    Context context;

    /*---------------Trending items----------------------*/
    RecyclerView otherServicesRecyclerView;
    private RecyclerView.LayoutManager otherServicesLayoutManager;
    TrendingServiceAdapter otherServicesAdapter;
    List<TrendingServiceItems> otherServicesItems;
    /*---------------------------------------------------*/

    public ServiceDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_service_detail, container, false);

        KenBurnsView kbv = (KenBurnsView) view.findViewById(R.id.image_background);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        button =(Button) view.findViewById(R.id.book_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ServicesAddFragment fragment = new ServicesAddFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        /*------------------Trending Items--------------------------*/
        otherServicesRecyclerView = (RecyclerView) view.findViewById(R.id.otherServiceRecyclerView);

        otherServicesItems = getOtherServiceItem();

        otherServicesRecyclerView.setHasFixedSize(true);

        otherServicesLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        otherServicesRecyclerView.setLayoutManager(otherServicesLayoutManager);
        otherServicesAdapter = new TrendingServiceAdapter(getActivity(), otherServicesItems);
        otherServicesRecyclerView.setAdapter(otherServicesAdapter);

        /*------------------------------------------------------------*/

        return view;
    }

    public List<TrendingServiceItems> getOtherServiceItem(){
        otherServicesItems = new ArrayList<TrendingServiceItems>();

        otherServicesItems.add(new TrendingServiceItems(R.drawable.plumber1, "Plumber", "Starting from", "Rs 1000"));
        otherServicesItems.add(new TrendingServiceItems(R.drawable.repairing, " Gadgets Repair", "Starting from", "Rs 1000"));
        otherServicesItems.add(new TrendingServiceItems(R.drawable.plumber3, "Electrics", "Electric", "Rs 1000"));
        otherServicesItems.add(new TrendingServiceItems(R.drawable.repair, "Home Appliances", "Starting from", "Rs 1000"));

        otherServicesItems.add(new TrendingServiceItems(R.drawable.plumber1, "Plumber", "Starting from", "Rs 1000"));
        otherServicesItems.add(new TrendingServiceItems(R.drawable.repairing, " Gadgets Repair", "Starting from", "Rs 1000"));
        otherServicesItems.add(new TrendingServiceItems(R.drawable.plumber3, "Electrics", "Electric", "Rs 1000"));
        otherServicesItems.add(new TrendingServiceItems(R.drawable.repair, "Home Appliances", "Starting from", "Rs 1000"));

        return otherServicesItems;
    }

}
