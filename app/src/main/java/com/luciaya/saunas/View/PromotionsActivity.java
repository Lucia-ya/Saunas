package com.luciaya.saunas.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.luciaya.saunas.Helper.PromotionsAdapter;
import com.luciaya.saunas.R;
import com.luciaya.saunas.TestData.Sauna;
import com.luciaya.saunas.TestData.SaunaLab;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PromotionsActivity extends AppCompatActivity {
    private static final String TAG = "PromotionsActivity";
    @BindView(R.id.promotions_recycler_view)
    RecyclerView recyclerView;

    private PromotionsAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promitions);
        ButterKnife.bind(this);

        //set ActionBar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_promotions);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        updateUI();

    }

    private void updateUI() {
        SaunaLab saunaLab = SaunaLab.get();
        List<Sauna> saunas = saunaLab.getSaunas(); //массив с контактами
        if (mAdapter == null) { //если адаптера еще нет, создать. Если есть, обновить список саун
            Log.d(TAG, "updateUI: mAdapter == null");
            mAdapter = new PromotionsAdapter(this.getApplicationContext(), saunas);
            recyclerView.setAdapter(mAdapter);
        } else {
            Log.d(TAG, "updateUI: mAdapter != null");
            mAdapter.setSaunas(saunas);
            mAdapter.notifyDataSetChanged();
            recyclerView.setAdapter(mAdapter);
        }

    }
}
