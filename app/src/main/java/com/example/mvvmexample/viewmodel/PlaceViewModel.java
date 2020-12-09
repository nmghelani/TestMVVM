package com.example.mvvmexample.viewmodel;

import com.example.mvvmexample.model.Place;
import com.example.mvvmexample.repository.PlaceRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlaceViewModel extends ViewModel {

    private MutableLiveData<List<Place>> mPlaces;
    private PlaceRepository mPlaceRepo;

    public PlaceViewModel() {
        mPlaceRepo = new PlaceRepository();
    }

    public LiveData<List<Place>> getPlaces() {
        return mPlaces;
    }
}
