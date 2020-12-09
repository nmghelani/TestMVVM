package com.example.mvvmexample;

import android.os.Bundle;
import android.util.Log;

import com.example.mvvmexample.adapter.PlaceAdapter;
import com.example.mvvmexample.databinding.ActivityMainBinding;
import com.example.mvvmexample.model.Place;
import com.example.mvvmexample.viewmodel.PlaceViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding mActivityMainBinding;
    private MainActivity mContext;
    private PlaceViewModel mPlaceViewModel;
    private PlaceAdapter placeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mActivityMainBinding.getRoot());
        mContext = MainActivity.this;

//        mPlaceViewModel = ViewModelProvider.of;
        mPlaceViewModel.getPlaces().observe(mContext, new Observer<List<Place>>() {
            @Override
            public void onChanged(List<Place> places) {
                //Load the recyclerview again
                if (placeAdapter != null) {
                    placeAdapter.notifyDataSetChanged();
                }
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView() {
        placeAdapter = new PlaceAdapter(mContext, new ArrayList<>());
        mActivityMainBinding.rvPlace.setLayoutManager(new LinearLayoutManager(mContext));
        mActivityMainBinding.rvPlace.setAdapter(placeAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
    }
}