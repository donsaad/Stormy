package com.lotum.ui;

import android.app.ListActivity;
import android.os.Bundle;

import com.lotum.R;
import com.lotum.adapters.DailyAdapter;
import com.lotum.weather.Daily;

public class DailyForecastActivity extends ListActivity {

    private Daily[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        // TODO: get forecast data from main activity into mDays

        DailyAdapter adapter = new DailyAdapter(this, mDays);

    }

}
