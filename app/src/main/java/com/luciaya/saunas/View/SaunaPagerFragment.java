package com.luciaya.saunas.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luciaya.saunas.R;
import com.luciaya.saunas.TestData.Sauna;

import java.util.UUID;

public class SaunaPagerFragment extends Fragment {
    private Sauna mSauna;
    private static final String ARG_SAUNA_ID = "contact_id";
    private final String TAG = "SaunaPagerFragment";

    public static SaunaPagerFragment newInstance(UUID saunaId) { //принимаем параметры от активности
        Bundle args = new Bundle();
        args.putSerializable(ARG_SAUNA_ID, saunaId);
        SaunaPagerFragment fragment = new SaunaPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_pager_sauna, container, false);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.sauna_fragment, menu);
    }






}
