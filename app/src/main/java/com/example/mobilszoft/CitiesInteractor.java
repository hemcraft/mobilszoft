package com.example.mobilszoft;

import android.util.Log;

public class CitiesInteractor {

    interface OnSaveFinishedListener {
        void onSuccess();
    }

    public void saveCitiesToDatabase(){
        Log.v("save", "The cities are stored.");
    }

}
