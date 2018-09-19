package com.example.puza.homeservice.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.puza.homeservice.fragments.services.ServicesTypesFragment;
import com.example.puza.homeservice.fragments.services.Tab2;
import com.example.puza.homeservice.fragments.services.Tab3;
import com.example.puza.homeservice.fragments.services.Tab4;
import com.example.puza.homeservice.fragments.services.Tab5;
import com.example.puza.homeservice.fragments.services.Tab6;

public class PagerTabAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public PagerTabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //initializing tabCount variable
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ServicesTypesFragment tab1 = new ServicesTypesFragment();
                return tab1;
            case 1:
                Tab2 tab2 = new Tab2();
                return  tab2;
            case 2:
                Tab3 tab3 = new  Tab3();
                return  tab3;
            case 3:
                Tab4 tab4 = new Tab4();
                return tab4;
            case 4:
                Tab5 tab5 = new Tab5();
                return  tab5;
            case 5:
                Tab6 tab6 = new  Tab6();
                return  tab6;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;

    }
}
