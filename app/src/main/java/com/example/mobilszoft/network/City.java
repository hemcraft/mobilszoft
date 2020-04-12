package com.example.mobilszoft.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class City {
    @SerializedName("post code")
    private String postCode;
    @SerializedName("country")
    private String country;
    @SerializedName("country abbreviation")
    private String countryAbbreviation;
    @SerializedName("places")
    private List<Place> places = null;

    @SerializedName("post code")
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
