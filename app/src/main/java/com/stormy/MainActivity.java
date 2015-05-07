package com.stormy;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String ERROR_DATA = "data_exception";
    public static final String ERROR_NETWORK = "network_unavailable";
    private CurrentWeather mCurrentWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "ecd27683ebc9adbc2921c2b44d9924c4";
        double latitude = 37.8267;
        double longitude = -122.423;
        String forecastUrl = "https://api.forecast.io/forecast/" + apiKey +
                "/" + latitude + "," + longitude;

        if (isNetworkAvailable()) {


            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(forecastUrl)
                    .build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {

                }

                @Override
                public void onResponse(Response response) throws IOException {

                    try {
                        String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                        if (response.isSuccessful()) {
                            mCurrentWeather = getCurrentDetails(jsonData);
                        } else {
                            alertUserAboutError(ERROR_DATA);
                        }
                    }
                    catch (IOException e) {
                        Log.e(TAG, "Exception caught: ", e);
                    }
                    catch (JSONException e) {
                        Log.e(TAG, "Exception caught: ", e);
                    }
                }
            });
        }
        else {
            alertUserAboutError(ERROR_NETWORK);
        }
    }

    private CurrentWeather getCurrentDetails(String jsonData) throws JSONException {
        JSONObject forecast = new JSONObject(jsonData);
        JSONObject weather = forecast.getJSONObject("currently");
        String timeZone = weather.getString("summary");
        Log.i(TAG, "From JSON:" + timeZone);

        CurrentWeather currentWeather = new CurrentWeather();
        currentWeather.setHumidity(weather.getDouble("humidity"));
        currentWeather.setSummary(weather.getString("summary"));
        currentWeather.setTime(weather.getLong("time"));
        currentWeather.setIcon(weather.getString("icon"));
        currentWeather.setTemperature(weather.getDouble("temperature"));
        currentWeather.setPercipChance(weather.getDouble("precipProbability"));
        currentWeather.setTimeZone(timeZone);

        Log.d(TAG, currentWeather.getFormattedTime());

        return currentWeather;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private void alertUserAboutError(String error) {
        if(error.equals(ERROR_DATA)) {
            DataAlertDialogFragment dialog = new DataAlertDialogFragment();
            dialog.show(getFragmentManager(), "error_dialog");
        }
        else if(error.equals(ERROR_NETWORK)) {
            NetworkAlertDialogFragment dialog = new NetworkAlertDialogFragment();
            dialog.show(getFragmentManager(), "error_dialog");
        }
    }
}
