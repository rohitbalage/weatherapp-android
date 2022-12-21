package com.rrbofficial.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
        private TextView city, temperature, weatherCondition, humidity, maxTemperature, mimTemperature, pressure, wind;
        private ImageView imageView;
        private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.textViewCity);
        temperature = findViewById(R.id.textViewTemp);
        weatherCondition = findViewById(R.id.textViewWeatherCondition);
       humidity = findViewById(R.id.textViewHumidity);
       maxTemperature = findViewById(R.id.textViewMaxTemp);
       pressure= findViewById(R.id.textViewPressure);
       wind = findViewById(R.id.textViewWind);
        imageView = findViewById(R.id.imageView);
       fab = findViewById(R.id.fab);


       fab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
    }
}