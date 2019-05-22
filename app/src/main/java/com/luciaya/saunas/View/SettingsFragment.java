package com.luciaya.saunas.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.luciaya.saunas.R;

public class SettingsFragment extends Fragment implements View.OnClickListener {

    private TextView cityText;
    private SwitchCompat promotions;
    private SwitchCompat notifications;
    private ConstraintLayout selectCity;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        cityText = view.findViewById(R.id.settings_city);
        selectCity = view.findViewById(R.id.settings_select_city);
        notifications = view.findViewById(R.id.settings_notifications_switch);
        promotions = view.findViewById(R.id.settings_promotions_switch);

        selectCity.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.settings_select_city:
                Toast.makeText(getActivity(), "Вы нажали: Выбрать город", Toast.LENGTH_SHORT).show();
        }
    }
}
