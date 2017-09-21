package com.lotum.ui;

import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.lotum.R;
import com.lotum.adapters.HourlyAdapter;
import com.lotum.weather.Hourly;

import java.util.Arrays;

public class HourlyForecastActivity extends AppCompatActivity {

    private Hourly[] mHours;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        Parcelable[] parcelables = getIntent().getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        mHours = Arrays.copyOf(parcelables, parcelables.length, Hourly[].class);

        HourlyAdapter adapter = new HourlyAdapter(this, mHours);
        mRecyclerView.setAdapter(adapter);

        // LinearLayoutManager for vertical and horizontal lists like our case here
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);

        mRecyclerView.setHasFixedSize(true); // improves performance for fixed size lists
    }


}
