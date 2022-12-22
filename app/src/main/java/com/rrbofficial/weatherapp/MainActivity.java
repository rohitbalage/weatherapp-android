package com.rrbofficial.weatherapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
        private TextView city, temperature, weatherCondition, humidity, maxTemperature, mimTemperature, pressure, wind;
        private ImageView imageView;
        private FloatingActionButton fab;

        LocationManager locationManager;
        LocationListener locationListener;
        double lat, lon;
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
       locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
       locationListener = new LocationListener() {
           @Override
           public void onLocationChanged(@NonNull Location location) {
               lat = location.getLatitude();
               lon = location.getLongitude();

               Log.e("lat",String.valueOf(lat));
               Log.e("lan",String.valueOf(lon));



           }
       };

       if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION )!= PackageManager.PERMISSION_GRANTED){
           ActivityCompat.requestPermissions (this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1 );

        }
       else{
           locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,500, 50,locationListener);
       }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode ==1 && permissions.length > 0
                && ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION )== PackageManager.PERMISSION_GRANTED){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,500, 50,locationListener);
        }
    }
}