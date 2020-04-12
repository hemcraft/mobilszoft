package com.example.mobilszoft;

import android.util.Log;

import com.example.mobilszoft.db.City;

import java.util.List;

public class CitiesInteractor {

    interface OnSaveFinishedListener {
        void onSuccess();
    }

    public void saveCityToDatabase(City city){
        city.save();
        Log.v("save", "The cities are saved.");
    }

    public List<City> getCitiesFromDatabase(){
        List<City> cities = City.listAll(City.class);
        Log.v("get", "The cities are available.");
        return cities;
    }

    public void clearDatabase(){
        City.deleteAll(City.class);
        Log.v("delete", "The database is cleared.");
    }

}
