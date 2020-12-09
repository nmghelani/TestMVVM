package com.example.mvvmexample.repository;

import com.example.mvvmexample.model.Place;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class PlaceRepository {

    public PlaceRepository() {

    }

    private ArrayList<Place> dataSet = new ArrayList<>();

    public MutableLiveData<List<Place>> getPlaces() {
        setPlaces();
        MutableLiveData<List<Place>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setPlaces() {
        dataSet.add(new Place("","Test1"));
        dataSet.add(new Place("","Test2"));
        dataSet.add(new Place("","Test3"));
        dataSet.add(new Place("","Test4"));
        dataSet.add(new Place("","Test5"));
    }
}
