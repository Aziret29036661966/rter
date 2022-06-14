package com.example.mvvm.domain.di;

import static com.example.mvvm.BuildConfig.BASE_URL;

import com.example.mvvm.data.network.RickAndMortyApi;
import com.example.mvvm.data.network.repo.MainRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public RickAndMortyApi providerApi() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RickAndMortyApi.class);
    }

    @Provides
    @Singleton
    public MainRepository providerMainRepo(RickAndMortyApi api) {
        return new MainRepository(api);
    }
}
