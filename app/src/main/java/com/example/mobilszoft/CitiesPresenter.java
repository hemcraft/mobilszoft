package com.example.mobilszoft;

import android.util.Log;

public class CitiesPresenter implements CitiesInteractor.OnSaveFinishedListener{

    private CitiesView citiesView;
    private CitiesInteractor citiesInteractor;

    CitiesPresenter(CitiesView citiesView, CitiesInteractor citiesInteractor){
        this.citiesView = citiesView;
        this.citiesInteractor = citiesInteractor;
    }

    public void saveCities(){
        citiesInteractor.saveCitiesToDatabase();
    }


    @Override
    public void onSuccess() {
        Log.v("save", "The cities are stored.");
    }
}
