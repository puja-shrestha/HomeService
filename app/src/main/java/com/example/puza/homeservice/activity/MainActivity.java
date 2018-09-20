package com.example.puza.homeservice.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.fragments.HomeFragment;
import com.example.puza.homeservice.fragments.MoreFragment;
import com.example.puza.homeservice.fragments.ProfileFragment;
import com.example.puza.homeservice.fragments.SearchFragment;
import com.example.puza.homeservice.helper.BottomNavigationHelper;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String SELECTED_ITEM = "arg_selected_item";

    private BottomNavigationView mBottomNav;
    private int mSelectedItem;
    FragmentTransaction transaction;

    Toolbar toolbar;
    ImageView backPress;

    //Navigation Drawer
    private DrawerLayout mDrawerLayout;
    private ImageView navigationMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*--------------------------- Navigation Drawer --------------------------*/

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        navigationMenu = (ImageView)findViewById(R.id.navigationMenu);
        navigationMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        setUpBottomNavigation();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

//    @Override
//    public void onBackPressed() {
//        MenuItem homeItem = mBottomNav.getMenu().getItem(0);
//        if (mSelectedItem != homeItem.getItemId()) {
//            // select home item
//            selectFragment(homeItem);
//        } else if (mSelectedItem == homeItem.getItemId()) {
//            onBackPressed();
//
//        }
//    }

//    @Override
//    public void onBackPressed() {
//
//        int count = getFragmentManager().getBackStackEntryCount();
//
//        if (count == 0) {
//            super.onBackPressed();
//            //additional code
//        } else {
//            getFragmentManager().popBackStack();
//        }
//
//    }

    private void setUpBottomNavigation() {
        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationHelper.removeShiftMode(mBottomNav);
        if (mBottomNav != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = mBottomNav.getMenu();
            selectFragment(menu.getItem(0));
            mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    selectFragment(item);
                    return true;
                }
            });
        }

    }

    private void selectFragment(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.menu_home:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HomeFragment());
                break;
            case R.id.menu_search:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new SearchFragment());
                break;
            case R.id.menu_profile:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new ProfileFragment());
                break;
            case R.id.menu_more:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new MoreFragment());
                break;
        }
        transaction.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        int id = item.getItemId();

        if(id == R.id.profile){
            fragment = new ProfileFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }else if (id == R.id.services){
            fragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }else if (id == R.id.packages){

        }else if (id == R.id.cart){

        }else if (id == R.id.about){

        }else if (id == R.id.gallery){

        }else if (id == R.id.booking){

        }else if (id == R.id.location){

        }else if (id == R.id.terms_conditions){

        }else if (id == R.id.logout){

        }

        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
