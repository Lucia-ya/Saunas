package com.luciaya.saunas.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.luciaya.saunas.Helper.BottomNavigationViewHelper;
import com.luciaya.saunas.R;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;
    private FragmentTransaction ft;
    final Fragment fragmentCatalog = new CatalogFragment();
    final Fragment fragmentSelection = new SelectionFragment();
    final Fragment fragmentSettings = new SettingsFragment();
    private Fragment active = fragmentCatalog;
    private final String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView); //Disable shift mode in BottomNavigationView

        fm.beginTransaction().add(R.id.main_container, fragmentSettings, "3").hide(fragmentSettings).commit();
        fm.beginTransaction().add(R.id.main_container, fragmentSelection, "2").hide(fragmentSelection).commit();
        fm.beginTransaction().add(R.id.main_container, fragmentCatalog, "1").commit();
        active = fragmentCatalog;

        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setTitle(R.string.catalog_title);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.d(TAG, "onNavigationItemReselected: selected " + item.getItemId());
            switch (item.getItemId()) {
                case R.id.action_catalog:
                    Log.d(TAG, "onNavigationItemReselected: action_catalog");
                    if (active != fragmentCatalog) {
                        fm.beginTransaction().hide(active).show(fragmentCatalog).commit();
                        getSupportActionBar().setDisplayShowCustomEnabled(true);
                        getSupportActionBar().setCustomView(R.layout.actionbar_main);
                        active = fragmentCatalog;
                    }
                    return true;
                case R.id.action_favorites:
                    Log.d(TAG, "onNavigationItemSelected: action_favirites");
//                        fragment = new FavoritesFragment();
                    return true;
                case R.id.action_selection:
                    Log.d(TAG, "onNavigationItemReselected: action_selection");
                    if (active != fragmentSelection) {
                        fm.beginTransaction().hide(active).show(fragmentSelection).commit();
                        getSupportActionBar().setDisplayShowCustomEnabled(true);
                        getSupportActionBar().setCustomView(R.layout.actionbar_selection);
                        //listeners for reset button
                        getSupportActionBar().getCustomView().findViewById(R.id.select_actionbar_reset).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(), "Вы нажали: Сбросить", Toast.LENGTH_SHORT).show();
                            }
                        });
                        active = fragmentSelection;
                    }
                    return true;
                case R.id.action_on_map:
                    Log.d(TAG, "onNavigationItemSelected: action_on_map");
//                        fragment = new OnMapFragment();
                    return true;
                case R.id.action_settings:
                    Log.d(TAG, "onNavigationItemSelected: action_settings");
                    if (active != fragmentSettings) {
                        fm.beginTransaction().hide(active).show(fragmentSettings).commit();
                        getSupportActionBar().setDisplayShowCustomEnabled(true);
                        getSupportActionBar().setCustomView(R.layout.actionbar_settings);
                    }
                    return true;
            }
            return false;
        }
    };


}
