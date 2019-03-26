package com.example.beyhive;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("beyhive.json")

    Call<MonRestResponse>getListPokemon();
}
