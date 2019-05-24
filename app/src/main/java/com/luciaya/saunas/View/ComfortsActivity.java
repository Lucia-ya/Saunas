package com.luciaya.saunas.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.luciaya.saunas.Helper.ComfortsAdapter;
import com.luciaya.saunas.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComfortsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ComfortsActivity";
    @BindView(R.id.comforts_show_button)
    Button show;
    @BindView(R.id.comforts_recycler_view)
    RecyclerView mRecyclerView;
    private ImageButton backButton;
    private TextView resetText;

    ComfortsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comforts);
        ButterKnife.bind(this);

        //set ActionBar layout
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_comforts);

        //find actionBar buttons in layout
        backButton = actionBar.getCustomView().findViewById(R.id.comfort_actionbar_back);
        resetText = actionBar.getCustomView().findViewById(R.id.comfort_actionbar_reset);

        //set listeners on buttons
        show.setOnClickListener(this);
        backButton.setOnClickListener(this);
        resetText.setOnClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        updateUI();



    }

    //при возвращении назад в активность, обновляем адаптер
    private void updateUI() {
        List<String> comforts = new ArrayList<>(Arrays.asList("Wi-Fi интернет", "Банкетный зал",
                "Бассейн", "Беседка", "Бильярд", "Гостиничные номера", "Джакузи", "Комната отдыха",
                "Купель", "Кухня", "Мангал", "Массажное кресло", "Массажный кабинет", "Танцпол",
                "Теплые полы"));
        if (adapter == null) { //если адаптера еще нет, создать. Если есть, обновить список саун
            Log.d(TAG, "updateUI: Adapter == null");
            adapter = new ComfortsAdapter(this, comforts);
            mRecyclerView.setAdapter(adapter);
        } else {
            Log.d(TAG, "updateUI: Adapter != null");
            adapter.setComforts(comforts);
            adapter.notifyDataSetChanged();
            mRecyclerView.setAdapter(adapter);
        }
    }

    public static Intent newIntent(Context packageContext) { //добавление интента с передачей параметров
        Intent intent = new Intent(packageContext, ComfortsActivity.class);
        return intent;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.comforts_show_button:
                Toast.makeText(this, "Вы нажали: Показать предложения", Toast.LENGTH_SHORT).show();
                break;
            case R.id.comfort_actionbar_back:
                onBackPressed();
                break;
            case R.id.comfort_actionbar_reset:
                Toast.makeText(this, "Вы нажали: Сбросить", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
