package com.example.puza.homeservice.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.puza.homeservice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectPartnerFragment extends Fragment {

    private Button select_partners;

    public SelectPartnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_partner, container, false);

        TextView textView = (TextView) view.findViewById(R.id.text3);
        SpannableString content = new SpannableString("View More");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);

        select_partners = (Button)view.findViewById(R.id.select_partners);

        select_partners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DeliveryAddressFragment fragment = new DeliveryAddressFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }

}
