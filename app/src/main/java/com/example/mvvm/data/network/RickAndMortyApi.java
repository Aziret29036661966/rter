package com.example.mvvm.data.network;

import com.example.mvvm.domain.entity.Info;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RickAndMortyApi {
    @GET("character")
    Call<Info> getCharacter();
}
