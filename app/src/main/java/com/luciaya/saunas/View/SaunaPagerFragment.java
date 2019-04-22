package com.luciaya.saunas.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.luciaya.saunas.R;
import com.luciaya.saunas.TestData.Sauna;

import java.util.UUID;

public class SaunaPagerFragment extends Fragment {
    private Sauna mSauna;
    private static final String ARG_SAUNA_ID = "contact_id";

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
        View view = inflater.inflate(R.layout.fragment_pager_sauna, container, false);


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.sauna_pager_fragment_options, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.title_item_sauna:
                // Handle fragment menu item
                return true;
            default:
                // Not one of ours. Perform default menu processing
                return super.onOptionsItemSelected(item);
        }
    }




}
