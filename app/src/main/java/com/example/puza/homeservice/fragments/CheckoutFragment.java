package com.example.puza.homeservice.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.puza.homeservice.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckoutFragment extends Fragment {

    private RadioGroup radioGroup;
    private RadioButton radioFemale;
    private RadioButton radioMale;
    private Button btnDisplay;

    private Button btn_checkout;

    public CheckoutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_checkout, container, false);

        radioGroup = (RadioGroup) view.findViewById(R.id.radio);
        radioFemale = (RadioButton)view.findViewById(R.id.radioFemale);
        radioMale = (RadioButton)view.findViewById(R.id.radioMale);

        btn_checkout = (Button)view.findViewById(R.id.btn_checkout);

        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new SweetAlertDialog(getContext(), SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Order successful!")
                        .show();
            }
        });


        CheckBox checkbox = (CheckBox)view.findViewById(R.id.checkBox1);
        TextView textView = (TextView)view.findViewById(R.id.terms);

        checkbox.setText("");
        textView.setText(Html.fromHtml("By placing order, I agree to the " +
                "<a href='id.web.freelancer.example.TCActivity://Kode'>Terms and Conditions</a>"));
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}
