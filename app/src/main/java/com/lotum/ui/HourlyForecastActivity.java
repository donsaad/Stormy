package com.lotum.ui;

import android.os.Parcelable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lotum.R;
import com.lotum.adapters.HourlyAdapter;
import com.lotum.weather.Hourly;

import java.util.Arrays;

public class HourlyForecastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        Parcelable[] parcelables = getIntent().getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        Hourly[] hours = Arrays.copyOf(parcelables, parcelables.length, Hourly[].class);

        HourlyAdapter adapter = new HourlyAdapter(this, hours);
        recyclerView.setAdapter(adapter);

        // LinearLayoutManager for vertical and horizontal lists like our case here
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        recyclerView.setHasFixedSize(true); // improves performance for fixed size lists
    }


}
