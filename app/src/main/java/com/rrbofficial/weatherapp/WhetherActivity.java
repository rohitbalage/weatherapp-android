package com.rrbofficial.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WhetherActivity extends AppCompatActivity {
    private TextView cityWeather, temperatureWeather, Condition, humidityWeather, maxTemperatureWeather, mimTemperatureWeather, pressureWeather, windWeather;
    private ImageView imageViewWeather;
    private Button search;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whether);

        cityWeather = findViewById(R.id.textViewCityWhether);
        temperatureWeather = findViewById(R.id.textViewTempWhether);
        Condition = findViewById(R.id.textViewWeatherCondition);
        humidityWeather = findViewById(R.id.textViewHumidityWhether);
        maxTemperatureWeather = findViewById(R.id.textViewMaxTempWhether);
        mimTemperatureWeather = findViewById(R.id.textViewMinTempWhether);
        pressureWeather= findViewById(R.id.textViewPressureWhether);
        windWeather = findViewById(R.id.textViewWindWhether);
        imageViewWeather = findViewById(R.id.imageViewWhether);
       search = findViewById(R.id.search);
        editText = findViewById(R.id.editTextCityName);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}