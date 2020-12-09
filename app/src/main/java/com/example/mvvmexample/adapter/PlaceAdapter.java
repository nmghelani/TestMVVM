package com.example.mvvmexample.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.mvvmexample.R;
import com.example.mvvmexample.databinding.ItemPlaceBinding;
import com.example.mvvmexample.model.Place;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private final Context mContext;
    private final List<Place> places;

    public PlaceAdapter(Context mContext, List<Place> places) {
        this.mContext = mContext;
        this.places = places;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPlaceBinding mItemPlaceBinding = ItemPlaceBinding.inflate(((Activity) mContext).getLayoutInflater(), parent, false);
        return new ViewHolder(mItemPlaceBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(places.get(position));
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemPlaceBinding mItemPlaceBinding;

        public ViewHolder(@NonNull ItemPlaceBinding mItemPlaceBinding) {
            super(mItemPlaceBinding.getRoot());
            this.mItemPlaceBinding = mItemPlaceBinding;
        }

        public void bind(Place place) {
            mItemPlaceBinding.tvPlace.setText(place.getName());
            Glide.with(mContext)
                    .load(place.getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(mItemPlaceBinding.ivPlace);
        }
    }
}
