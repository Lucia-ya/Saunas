package com.luciaya.saunas.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.luciaya.saunas.Helper.BottomNavigationViewHelper;
import com.luciaya.saunas.R;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView); //Disable shift mode in BottomNavigationView

        fragmentManager = getSupportFragmentManager();
        fragment = new CatalogFragment();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.main_container, fragment).commit();

        //fragmentManager.beginTransaction().add(R.id.main_container, fragment).commit();
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.action_catalog:
                        fragment = new CatalogFragment();
                        break;
//                    case R.id.action_favorites:
//                        fragment = new FavoritesFragment();
//                        break;
//                    case R.id.action_selection:
//                        fragment = new SelectionFragment();
//                        break;
//                    case R.id.action_on_map:
//                        fragment = new OnMapFragment();
//                        break;
//                    case R.id.action_settings:
//                        fragment = new SettingsFragment();
//                        break;
                }
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.main_container, fragment).commit();
            }
        });
    }
}
