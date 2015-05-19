package com.lotum.weather;

import com.lotum.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Saad on 07/05/2015.
 */
public class Current {

    private String mIcon;
    private long mTime;
    private double mTemperature;
    private double mHumidity;
    private double mPercipChance;
    private String mSummary;
    private String mTimeZone;

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public int getIconId() {
        return Forecast.getIconId(mIcon);
    }

    public long getTime() {
        return mTime;
    }

    public String getFormattedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone(mTimeZone));
        Date date = new Date(getTime() * 1000);

        return formatter.format(date);
    }

    public void setTime(long time) {
        mTime = time;
    }

    public int getTemperature() {
        return (int) Math.round(mTemperature);
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(double humidity) {
        mHumidity = humidity;
    }

    public int getPercipChance() {
        double percentage = mPercipChance * 100;
        return (int) Math.round(percentage);
    }

    public void setPercipChance(double percipChance) {
        mPercipChance = percipChance;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }
}
