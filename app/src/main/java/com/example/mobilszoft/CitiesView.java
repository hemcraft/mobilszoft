package com.example.mobilszoft;

import com.example.mobilszoft.db.City;

import java.util.List;

public interface CitiesView {

    void showCities(List<City> cityList);

    Double calculateDistances(Double latitude, Double longitude);
}
