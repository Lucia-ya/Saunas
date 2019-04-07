package com.luciaya.saunas.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luciaya.saunas.Helper.SaunaAdapter;
import com.luciaya.saunas.R;
import com.luciaya.saunas.TestData.Sauna;
import com.luciaya.saunas.TestData.SaunaLab;

import java.util.List;

public class CatalogFragment extends android.support.v4.app.Fragment {

    private SearchView mSearchView;
    private RecyclerView mRecyclerView;
    private SaunaAdapter mAdapter;
    private List<Sauna> mSaunas;

    public CatalogFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        mSearchView = (SearchView) view.findViewById(R.id.search_view_catalog);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_catalog);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

        return view;
    }

    private void updateUI() {
        SaunaLab saunaLab = SaunaLab.get();
        List<Sauna> saunas = saunaLab.getSaunas(); //массив с контактами
        if (mAdapter == null) { //если адаптера еще нет, создать. Если есть, обновить список саун
            mAdapter = new SaunaAdapter(saunas);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setSaunas(saunas);
            mAdapter.notifyDataSetChanged();
        }
    }





}
