package com.example.beyhive;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyController {
    private MainActivity activity;

    public MyController(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void onStart(){

        //Pour ceux qui veulent aller plus loin
        //Singleton
        //Pour ceux qui veulent aller encore plus loin
        // Injection de dépendances

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/AmySian/BeyHiveAPI/master/")
                //.baseUrl("https://raw.githubusercontent.com/Metasilveur/MobileFireEmblem/master/dogApi.json")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestApi restApi = retrofit.create(RestApi.class);

        Call<MonRestResponse> call = restApi.getListPokemon();
        call.enqueue(new Callback<MonRestResponse>() {
            @Override
            public void onResponse(Call<MonRestResponse> call, Response<MonRestResponse> response) {
                MonRestResponse restResponse = response.body();
                List<MonApi> listPokemon = restResponse.getResults();
                activity.showList(listPokemon);
            }

            @Override
            public void onFailure(Call<MonRestResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error because onFailure");
            }
        });
    }
}