package com.rrbofficial.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        Condition = findViewById(R.id.textViewWeatherConditionWeather);
        humidityWeather = findViewById(R.id.textViewHumidityWhether);
        maxTemperatureWeather = findViewById(R.id.textViewMaxTempWhether);
        mimTemperatureWeather = findViewById(R.id.textViewMinTempWhether);
        pressureWeather = findViewById(R.id.textViewPressureWhether);
        windWeather = findViewById(R.id.textViewWindWhether);
        imageViewWeather = findViewById(R.id.imageViewWhether);
        search = findViewById(R.id.search);
        editText = findViewById(R.id.editTextCityName);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = editText.getText().toString();
            getWeatherData(cityName);
            editText.setText("");
            }
        });
    }

    public  void getWeatherData(String name){
        weatherAPI weatherAPI = RetrofitWeather.getclient().create(weatherAPI.class);
        Call<OpenWeatherMap> call = weatherAPI.getWeatherWithCityName(name);
        call.enqueue(new Callback<OpenWeatherMap>() {
            @Override
            public void onResponse(Call<OpenWeatherMap> call, Response<OpenWeatherMap> response) {
                if (response.isSuccessful()) {
                    cityWeather.setText(response.body().getName()+","+response.body().getSys().getCountry());
                    temperatureWeather.setText(response.body().getMain().getTemp()+" °C");
                    Condition.setText(response.body().getWeather().get(0).getDescription());
                    humidityWeather.setText(":"+response.body().getMain().getHumidity()+"%");
                    maxTemperatureWeather.setText(":"+response.body().getMain().getTempMax()+" °C");
                    mimTemperatureWeather.setText(":"+response.body().getMain().getTempMin()+" °C");
                    pressureWeather.setText(":"+response.body().getMain().getPressure());
                    windWeather.setText(" : "+response.body().getWind().getSpeed());

                    String iconCode = response.body().getWeather().get(0).getIcon();
                    Picasso.get().load("https://openweathermap.org/img/wn/"+iconCode+"@2x.png").placeholder(R.drawable.ic_launcher_background).into(imageViewWeather);

                }
                else{
                    Toast.makeText(WhetherActivity.this,"City not found, please check the spelling", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<OpenWeatherMap> call, Throwable t) {

            }
        });
    }

}