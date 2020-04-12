package com.example.mobilszoft.network;

import com.google.gson.annotations.SerializedName;

public class Place {
    @SerializedName("place name")
    private String placeName;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("state")
    private String state;
    @SerializedName("state abbreviation")
    private String stateAbbreviation;
    @SerializedName("latitude")
    private String latitude;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
