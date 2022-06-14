package com.example.mvvm.data.network.repo;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm.data.network.RickAndMortyApi;
import com.example.mvvm.domain.entity.Info;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private final RickAndMortyApi api;

    @Inject
    public MainRepository(RickAndMortyApi api) {
        this.api = api;
    }

    public LiveData<Info> getCharacter() {
        MutableLiveData<Info> liveData = new MutableLiveData<>();
        api.getCharacter().enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        liveData.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
            }
        });
        return liveData;
    }
}

