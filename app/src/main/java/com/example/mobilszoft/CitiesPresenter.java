package com.example.mobilszoft;

import android.os.Handler;
import android.util.Log;

import com.example.mobilszoft.db.City;
import com.example.mobilszoft.network.CityApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CitiesPresenter implements CitiesInteractor.OnSaveFinishedListener{

    private CitiesView citiesView;
    private CitiesInteractor citiesInteractor;

    CitiesPresenter(CitiesView citiesView, CitiesInteractor citiesInteractor){
        this.citiesView = citiesView;
        this.citiesInteractor = citiesInteractor;
        //City.deleteAll(City.class);

        Callback<com.example.mobilszoft.network.City> cityCallback = new Callback<com.example.mobilszoft.network.City>() {
            @Override
            public void onResponse(Call<com.example.mobilszoft.network.City> call, Response<com.example.mobilszoft.network.City> response) {
                City cityDB = new City(
                        response.body().getPlaces().get(0).getPlaceName(),
                        response.body().getCountry(),
                        Double.parseDouble(response.body().getPlaces().get(0).getLatitude()),
                        Double.parseDouble(response.body().getPlaces().get(0).getLongitude()));

                if(!getCities().contains(cityDB)) {
                    saveCity(cityDB);
                }

                citiesView.showCities(getCities());
            }

            @Override
            public void onFailure(Call<com.example.mobilszoft.network.City> call, Throwable t) {
                Log.v("FAILURE", t.getMessage());
            }
        };

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.zippopotam.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //API REQUESTS
        CityApi cityApi = retrofit.create(CityApi.class);
        cityApi.getCity("hu", "1021").enqueue(cityCallback);
        cityApi.getCity("de", "01067").enqueue(cityCallback);
        cityApi.getCity("no", "0001").enqueue(cityCallback);
        cityApi.getCity("in", "110001").enqueue(cityCallback);
        cityApi.getCity("ru", "101000").enqueue(cityCallback);
        cityApi.getCity("nl", "1000").enqueue(cityCallback);
        cityApi.getCity("us", "90210").enqueue(cityCallback);
        cityApi.getCity("hu", "7400").enqueue(cityCallback);
        cityApi.getCity("us", "00210").enqueue(cityCallback);
        cityApi.getCity("pl", "00-001").enqueue(cityCallback);
        cityApi.getCity("mx", "01000").enqueue(cityCallback);
    }

    public void saveCity(City city){
        citiesInteractor.saveCityToDatabase(city);
    }

    public List<City> getCities() {
        return citiesInteractor.getCitiesFromDatabase();
    }


    @Override
    public void onSuccess() {
        Log.v("save", "The cities are stored.");
    }
}
