package com.lotum.weather;

import com.lotum.R;

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

    public static int getIconId(String iconString) {
        int iconId = R.drawable.clear_day;
        if(iconString.equals("clear-day")) {
            iconId = R.drawable.clear_day;
        }
        else if(iconString.equals("clear-night")) {
            iconId = R.drawable.clear_night;
        }
        if (iconString.equals("clear-day")) {
            iconId = R.drawable.clear_day;
        }
        else if (iconString.equals("clear-night")) {
            iconId = R.drawable.clear_night;
        }
        else if (iconString.equals("rain")) {
            iconId = R.drawable.rain;
        }
        else if (iconString.equals("snow")) {
            iconId = R.drawable.snow;
        }
        else if (iconString.equals("sleet")) {
            iconId = R.drawable.sleet;
        }
        else if (iconString.equals("wind")) {
            iconId = R.drawable.wind;
        }
        else if (iconString.equals("fog")) {
            iconId = R.drawable.fog;
        }
        else if (iconString.equals("cloudy")) {
            iconId = R.drawable.cloudy;
        }
        else if (iconString.equals("partly-cloudy-day")) {
            iconId = R.drawable.partly_cloudy;
        }
        else if (iconString.equals("partly-cloudy-night")) {
            iconId = R.drawable.cloudy_night;
        }

        return iconId;
    }
}
