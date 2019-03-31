package com.luciaya.saunas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SelectCityActivity extends Activity {
    private Spinner mSpinner;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mSpinner.setPrompt("Ваш город");

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

    }

}
