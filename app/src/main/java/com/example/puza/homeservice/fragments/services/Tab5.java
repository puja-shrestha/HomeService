package com.example.puza.homeservice.fragments.services;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.puza.homeservice.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Tab5 extends Fragment {

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;


    public Tab5() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab5, container, false);

        // Listview Data
        String products[] = {"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE",
                "iPhone 4S", "Samsung Galaxy Note 800",
                "Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro"};

        lv = (ListView) view.findViewById(R.id.list_view);
        inputSearch = (EditText) view.findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(getContext(), R.layout.list_item, R.id.product_name, products);
        lv.setAdapter(adapter);
//        lv.setVisibility(View.GONE);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                lv.setVisibility(View.VISIBLE);
            adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub
                lv.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

        return view;
    }

}
