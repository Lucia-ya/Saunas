package com.luciaya.saunas.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jaygoo.widget.OnRangeChangedListener;
import com.jaygoo.widget.RangeSeekBar;
import com.luciaya.saunas.R;

public class SelectionFragment extends Fragment implements View.OnClickListener, OnRangeChangedListener {
    private TextView roominess;
    private TextView price;
    private ConstraintLayout selectArray;
    private ConstraintLayout roomType;
    private ConstraintLayout comfort;
    private ConstraintLayout additionalServices;
    private ConstraintLayout accessories;
    private RangeSeekBar range_persons;
    private RangeSeekBar range_price;

    private View headerView;

    private int min_price;
    private int max_price;
    private int min_persons;
    private int max_persons;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selection, container, false);

        roominess = view.findViewById(R.id.select_roominess);
        price = view.findViewById(R.id.select_price);
        selectArray = view.findViewById(R.id.select_select_array);
        roomType = view.findViewById(R.id.select_room_type);
        comfort = view.findViewById(R.id.select_comfort);
        additionalServices = view.findViewById(R.id.select_additional_services);
        accessories = view.findViewById(R.id.select_accessories);
        range_persons = view.findViewById(R.id.select_persons_range);
        range_price = view.findViewById(R.id.select_price_range);

        selectArray.setOnClickListener(this);
        roomType.setOnClickListener(this);
        comfort.setOnClickListener(this);
        additionalServices.setOnClickListener(this);
        accessories.setOnClickListener(this);

        //set listener for rangeSeekBars
        range_price.setOnRangeChangedListener(this);
        range_persons.setOnRangeChangedListener(this);


        range_price.setIndicatorTextDecimalFormat("0");
        range_persons.setIndicatorTextDecimalFormat("0");

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_select_array:
                Toast.makeText(getActivity(), "Вы нажали: выверите район", Toast.LENGTH_SHORT).show();
                break;
            case R.id.select_room_type:
                Toast.makeText(getActivity(), "Вы нажали: Тип парной", Toast.LENGTH_SHORT).show();
                break;
            case R.id.select_comfort:

                Toast.makeText(getActivity(), "Вы нажали: Удобства", Toast.LENGTH_SHORT).show();
                break;
            case R.id.select_additional_services:
                Toast.makeText(getActivity(), "Вы нажали: Дополнительные удобства", Toast.LENGTH_SHORT).show();
                break;
            case R.id.select_accessories:
                Toast.makeText(getActivity(), "Вы нажали: Аксессуары", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //next three metods for RangeSeekBar
    @Override
    public void onRangeChanged(RangeSeekBar view, float leftValue, float rightValue, boolean isFromUser) {
        switch (view.getId()) {
            case R.id.select_price_range:
                min_price = (int)leftValue;
                max_price = (int) rightValue;
                price.setText(min_price + " - " + max_price + " руб.");
                break;
            case R.id.select_persons_range:
                min_persons = (int) leftValue;
                max_persons = (int) rightValue;
                roominess.setText(min_persons + " - " + max_persons + " чел.");
        }
    }

    @Override
    public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {

    }

    @Override
    public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {

    }
}
