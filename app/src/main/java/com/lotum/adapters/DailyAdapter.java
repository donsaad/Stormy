package com.lotum.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lotum.R;
import com.lotum.weather.Daily;

/**
 * Created by Saad on 19/05/2015.
 *
 */
public class DailyAdapter extends BaseAdapter {
    private Context mContext;
    private Daily[] mDailyArray;

    public DailyAdapter(Context context, Daily[] dailyArray) {
        mContext = context;
        mDailyArray = dailyArray;
    }

    @Override
    public int getCount() {
        return mDailyArray.length;
    }

    @Override
    public Object getItem(int position) {
        return mDailyArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, parent, false);
            holder = new ViewHolder();
            holder.icon = (ImageView) convertView.findViewById(R.id.img_daily_item_icon);
            holder.tempLabel = (TextView) convertView.findViewById(R.id.tv_temp_label);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.tv_day_label);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Daily daily = mDailyArray[position];

        holder.icon.setImageResource(daily.getIconId());
        holder.tempLabel.setText(daily.getTemperatureMax() + "");

        if(position == 0) {
            holder.dayLabel.setText("Today");
        }
        else {
            holder.dayLabel.setText(daily.getDayOfTheWeek());
        }

        return convertView;
    }

    public static class ViewHolder {
        ImageView icon;
        TextView dayLabel;
        TextView tempLabel; // temperature
    }
}




