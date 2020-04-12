package com.example.mobilszoft.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CityApi {

    @GET("/{country}/{zip}")
    Call<City> getCity(@Path("country") String country, @Path("zip") String zip);

}
