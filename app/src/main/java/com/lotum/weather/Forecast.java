package com.lotum.weather;

/**
 * Created by Saad on 18/05/2015.
 */
public class Forecast {
    private Current mCurrentForecast;
    private Hourly[] mHourlyForecast;
    private Daily[] mDailyForecast;

    public Current getCurrentForecast() {
        return mCurrentForecast;
    }

    public void setCurrentForecast(Current currentForecast) {
        mCurrentForecast = currentForecast;
    }

    public Hourly[] getHourlyForecast() {
        return mHourlyForecast;
    }

    public void setHourlyForecast(Hourly[] hourlyForecast) {
        mHourlyForecast = hourlyForecast;
    }

    public Daily[] getDailyForecast() {
        return mDailyForecast;
    }

    public void setDailyForecast(Daily[] dailyForecast) {
        mDailyForecast = dailyForecast;
    }
}
