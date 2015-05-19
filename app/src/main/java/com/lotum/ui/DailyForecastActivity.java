package com.lotum.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.lotum.R;
import com.lotum.adapters.DailyAdapter;
import com.lotum.weather.Daily;

import java.util.Arrays;

public class DailyForecastActivity extends ListActivity {

    private Daily[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Daily[].class);

        DailyAdapter adapter = new DailyAdapter(this, mDays);
        setListAdapter(adapter);

    }

}
