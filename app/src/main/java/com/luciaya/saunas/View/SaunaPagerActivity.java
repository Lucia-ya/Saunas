package com.luciaya.saunas.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.luciaya.saunas.R;
import com.luciaya.saunas.TestData.Sauna;
import com.luciaya.saunas.TestData.SaunaLab;

import java.util.List;
import java.util.UUID;

/**
 * Created by Lucia on 24.04.2019.
 */

public class SaunaPagerActivity extends AppCompatActivity{
    private static final String EXTRA_SAUNA_ID = "com.lucia-ya.android.saunas.sauna_id";
    private ViewPager mViewPager; //чтоб листать контакты прямо из представления
    private List<Sauna> mSaunas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sauna_pager);
        mViewPager = (ViewPager) findViewById(R.id.sauna_view_pager);
        mSaunas = SaunaLab.get().getSaunas();
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.action_bar_yellow), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setTitle(R.string.menu_bottom_catalog);
        //getSupportActionBar().setCustomView(R.layout.sauna_page_action_bar);

        UUID saunaId = (UUID) getIntent().getSerializableExtra(EXTRA_SAUNA_ID); //принимаем интент с парамером - айди сауны

        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Sauna sauna = mSaunas.get(position);
                return SaunaPagerFragment.newInstance(sauna.getUUID());
            }

            @Override
            public int getCount() { //вернуть количество контактов
                return mSaunas.size();
            }
        });
        for (int i = 0; i < mSaunas.size(); i++) {
            if (mSaunas.get(i).getUUID().equals(saunaId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    public static Intent newIntent(Context packageContext, UUID saunaId) { //добавление интента с передачей параметров
        Intent intent = new Intent(packageContext, SaunaPagerActivity.class);
        intent.putExtra(EXTRA_SAUNA_ID, saunaId);
        return intent;
    }


}
