package com.luciaya.saunas.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.luciaya.saunas.Helper.BottomNavigationViewHelper;
import com.luciaya.saunas.R;

public class MainActivity extends AppCompatActivity {
    private Fragment active;
    private FragmentManager fm = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;
    private FragmentTransaction ft;
    final Fragment fragmentCatalog = new CatalogFragment();
    final Fragment fragmentSaunaPager = new SaunaPagerFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView); //Disable shift mode in BottomNavigationView


        //fm.beginTransaction().add(R.id.main_container, fragmentSaunaPager, "2").hide(fragmentSaunaPager).commit();
        fm.beginTransaction().add(R.id.main_container, fragmentCatalog, "1").commit();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setTitle(R.string.catalog_title);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.action_catalog:
                        fm.beginTransaction().hide(active).show(fragmentCatalog).commit();
                        getSupportActionBar().setTitle(R.string.catalog_title);
                        active = fragmentCatalog;
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
            }
        });
    }


}
