package com.example.puza.homeservice.fragments.services;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.puza.homeservice.R;
import com.example.puza.homeservice.fragments.SelectPartnerFragment;
import com.example.puza.homeservice.fragments.ServicesAddFragment;

import java.util.Calendar;

public class Tab3 extends Fragment {


    //date and time
    private TextView chooseTime, selectDate;
    private Button select_partners;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3, container, false);

        /*-------------------------------Date and Time---------------------------------------*/

        select_partners =(Button) view.findViewById(R.id.select_partners);
        select_partners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SelectPartnerFragment fragment = new SelectPartnerFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        selectDate = view.findViewById(R.id.btnDate);
        selectDate.setOnClickListener(new View.OnClickListener() {

            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            int currentMinute = calendar.get(Calendar.MINUTE);

            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        chooseTime.setText(hourOfDay + ":" + minutes);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });


        chooseTime = view.findViewById(R.id.etChooseTime);
        // final TextView date = view.findViewById(R.id.tvSelectedDate);

        chooseTime.setOnClickListener(new View.OnClickListener() {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                                selectDate.setText(day + "/" + month + "/" + year);

                            }
                        }, year, month, dayOfMonth);

                datePickerDialog.show();
            }
        });

        /*-----------------------------------------------------------------------------------*/
        return view;
    }
}
