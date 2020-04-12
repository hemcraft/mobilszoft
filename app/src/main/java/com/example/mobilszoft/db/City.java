package com.example.mobilszoft.db;

import com.orm.SugarRecord;

public class City extends SugarRecord<City> {
    String name;
    String country;
    Double latitude;
    Double longitude;

    public City(){
    }

    public City(String name, String country, Double latitude, Double longitude){
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString(){
        return name + " : " + country;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof City){
            City p = (City) o;
            return this.name.equals(p.getName());
        } else
            return false;
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

    public Double getLatitude(){
        return latitude;
    }

    public Double getLongitude(){
        return longitude;
    }
}
