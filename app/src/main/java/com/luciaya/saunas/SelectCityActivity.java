package com.luciaya.saunas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**Вторая активность с выбором города */
public class SelectCityActivity extends Activity {
    private Spinner mSpinner;
    private Button mButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mButton = (Button) findViewById(R.id.city_button);


        String[] cities = new String[]{
                "Ваш город",
                "Москва",
                "Воронеж",
                "Липецк",
                "Екатеринбург",
                "Ростов"
        };
        List<String> cityesList = new ArrayList<>(Arrays.asList(cities)); //коллекция строк с городами

        //адаптер для спиннера
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner, cityesList){

            @Override
            public boolean isEnabled(int position){
                if(position == 1)
                {
                    // Disable the second item from Spinner
                    return false;
                }
                else
                {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position==0) {
                    // Set the disable item text color
                    tv.setVisibility(View.INVISIBLE); //скрываем нулевой индекс в коллекции
                }
                return view;
            }
        };

        adapter.setDropDownViewResource(R.layout.spinner);
        mSpinner.setAdapter(adapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectCityActivity.this, SaunasCatalogActivity.class);
                SelectCityActivity.this.startActivity(intent);
                SelectCityActivity.this.finish();
            }
        });

    }

}
