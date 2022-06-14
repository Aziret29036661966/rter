package com.example.mvvm.ui.fragment.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.data.network.repo.MainRepository;
import com.example.mvvm.domain.entity.Info;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {
    private final MainRepository repository;
    private LiveData<Info> liveData;

    @Inject
    public HomeViewModel(MainRepository repository) {
        this.repository = repository;
        liveData = new MutableLiveData<>();
    }

    public void getCharacter() {
        liveData = repository.getCharacter();
    }

    public LiveData<Info> getLiveData() {
        return liveData;
    }
}
