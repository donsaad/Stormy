package com.lotum.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lotum.R;
import com.lotum.weather.Hourly;

/**
 * Created by Saad on 20/05/2015.
 *
 */
public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.MyViewHolder> {

    private Hourly[] mHours;
    private Context mContext;

    public HourlyAdapter(Context context, Hourly[] hours) {
        mContext = context;
        mHours = hours;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hourly_list_item, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int i) {
    /* this method is like a bridge between the adapter
        and the bindData() method in MyViewHolder class
   */
        holder.bindData(mHours[i]); // "i" is a position

    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTimeLabel;
        public TextView mSummaryLabel;
        public TextView mTemperatureLabel;
        public ImageView mIconImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTimeLabel = (TextView) itemView.findViewById(R.id.tv_hourly_time_label);
            mSummaryLabel = (TextView) itemView.findViewById(R.id.tv_hourly_summary_label);
            mTemperatureLabel = (TextView) itemView.findViewById(R.id.tv_hourly_temp_label);
            mIconImage = (ImageView) itemView.findViewById(R.id.img_hourly_item_icon);

            itemView.setOnClickListener(this);
        }

        public void bindData(Hourly hourlyData) {
            mTimeLabel.setText(hourlyData.getHourOfTheDay());
            mSummaryLabel.setText(hourlyData.getSummary());
            mTemperatureLabel.setText(hourlyData.getTemperature() + "");
            mIconImage.setImageResource(hourlyData.getIconId());
        }

        @Override
        public void onClick(View v) {
            String time = mTimeLabel.getText().toString();
            String temp = mTemperatureLabel.getText().toString();
            String condition = mSummaryLabel.getText().toString();
            String message = String.format("At %s it will be %s and %s", time, temp, condition);
            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
        }
    }
}
