package com.example.mobilszoft;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.example.mobilszoft.db.City;
import com.example.mobilszoft.distance.LatLongDistance;
import com.example.mobilszoft.model.CustomAdapter;
import com.example.mobilszoft.model.ListElementCity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.widget.NestedScrollView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CitiesActivity extends AppCompatActivity implements CitiesView {

    private NestedScrollView nestedScrollView;
    private ListView listView;

    private LatLongDistance latLongDistance;
    private CitiesPresenter presenter = new CitiesPresenter(this, new CitiesInteractor());

    private double selfLongitude;
    private double selfLatitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.list_view);
        //listView.setsiz
        latLongDistance = new LatLongDistance();

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            selfLongitude = 19.040236;
            selfLatitude = 47.497913;
        }else{
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            selfLongitude = location.getLongitude();
            selfLatitude = location.getLatitude();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if( id == R.id.about){
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }

        if( id == R.id.refresh){
            presenter.reloadCities();
            Toast toast = Toast.makeText(getApplicationContext(), "Cities reloaded", Toast.LENGTH_SHORT);
            toast.show();

        }

        return true;
    }

    @Override
    public void downloadCities() {

    }

    @Override
    public void saveCities() {

    }

    @Override
    public void showCities(List<City> cityList) {
        List<String> cityArrayList = new ArrayList<String>();
        ArrayList<ListElementCity> cityElementArrayList = new ArrayList<>();

        for (City city: cityList
             ) {
            BigDecimal value = new BigDecimal(calculateDistances(city.getLatitude(), city.getLongitude()));
            value.setScale(2, RoundingMode.CEILING);

            ListElementCity listElementCity = new ListElementCity();
            listElementCity.setName(city.getName());
            listElementCity.setCountry(city.getCountry());
            listElementCity.setDistance(value.round(MathContext.DECIMAL32));
            listElementCity.setImage(selectCountryImage(city.getCountry()));

            cityElementArrayList.add(listElementCity);
        }

        CustomAdapter customAdapter = new CustomAdapter(this, cityElementArrayList);

        listView.setAdapter(customAdapter);
    }

    private int selectCountryImage(String country){
        int ret = 0;

        switch(country) {
            case "United States":
                // code block
                ret = R.drawable.us;
                break;
            case "Hungary":
                // code block
                ret = R.drawable.hu;
                break;
            default:
                ret = R.drawable.hu;
                // code block
        }

        return ret;
    }

    @Override
    public void sendNotification() {

    }

    @Override
    public Double calculateDistances(Double latitude, Double longitude) {
        return latLongDistance.distance(latitude, longitude, selfLongitude, selfLatitude);
    }
}
