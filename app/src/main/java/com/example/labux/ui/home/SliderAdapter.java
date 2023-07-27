package com.example.labux.ui.home;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.navigation.Navigation;

import com.example.labux.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {
    private final List<DataModel> mSliderItems;
    private View rootView;

    public SliderAdapter(View rootView, ArrayList<DataModel> sliderDataArrayList) {
        this.mSliderItems = sliderDataArrayList;
        this.rootView = rootView;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, null);
        return new SliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {
        DataModel item = mSliderItems.get(position);
        viewHolder.imageViewBackground.setImageResource(item.getDrawable());
        viewHolder.imageViewBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("selected", item);
                Navigation.findNavController(rootView).navigate(R.id.action_nav_home_to_ticket_form, bundle);
            }
        });
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        View itemView;
        ImageView imageViewBackground;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.imageItem);
            this.itemView = itemView;
        }
    }



}