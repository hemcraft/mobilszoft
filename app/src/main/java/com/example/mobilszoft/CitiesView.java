package com.example.mobilszoft;

import com.example.mobilszoft.db.City;

import java.util.List;

public interface CitiesView {

    void downloadCities();

    void saveCities();

    void showCities(List<City> cityList);

    void sendNotification();

    Double calculateDistances(Double latitude, Double longitude);
}
