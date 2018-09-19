package com.example.puza.homeservice.fragments.services;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.adapter.PagerTabAdapter;


public class AllServicesFragment extends Fragment implements TabLayout.OnTabSelectedListener  {

    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;


    public AllServicesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_services, container, false);


        //Adding toolbar to the activity
//        Toolbar toolbar=(Toolbar)view.findViewById(R.id.toolbar);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        //Initializing the tablayout
        tabLayout=(TabLayout)view.findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Gadgets Repair"));
        tabLayout.addTab(tabLayout.newTab().setText("Plumber"));
        tabLayout.addTab(tabLayout.newTab().setText("Washing"));
        tabLayout.addTab(tabLayout.newTab().setText("Repairing"));
        tabLayout.addTab(tabLayout.newTab().setText("Home Wall Cleaning"));
        tabLayout.addTab(tabLayout.newTab().setText("Home Electrician"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager=(ViewPager)view.findViewById(R.id.pager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //Creating our pager adapter
        PagerTabAdapter adapter=new PagerTabAdapter(getFragmentManager(),tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.addOnTabSelectedListener(this);

        return view;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab){
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab){

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab){

    }
}
