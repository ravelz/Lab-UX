package com.example.labux.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.example.labux.R;
import com.example.labux.ui.home.DataModel;
import com.example.labux.ui.home.DoubleSliderAdapter;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class TicketSliderAdapter extends SliderViewAdapter<TicketSliderAdapter.TicketSliderAdapterViewHolder> {
    private final List<DataModel> mSliderItems;
    private View rootView;

    public TicketSliderAdapter(View rootView, ArrayList<DataModel> sliderDataArrayList) {
        this.mSliderItems = sliderDataArrayList;
        this.rootView = rootView;
    }

    @Override
    public TicketSliderAdapter.TicketSliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_slide_item, null);
        return new TicketSliderAdapter.TicketSliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(TicketSliderAdapter.TicketSliderAdapterViewHolder viewHolder, final int position) {
        DataModel item = mSliderItems.get(position);
        viewHolder.imageViewBackground.setImageResource(item.getDrawable());
        viewHolder.titleTextView.setText(item.getTitle());
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("IDR"));

        String formatedPrice = format.format(item.getPrice());
        viewHolder.priceTextView.setText(formatedPrice);
        viewHolder.dateTextView.setText(item.getDate());
        viewHolder.imageViewBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("selected", item);
                Navigation.findNavController(rootView).navigate(R.id.action_nav_gallery_to_ticket_form, bundle);
            }
        });
        viewHolder.buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("selected", item);
                Navigation.findNavController(rootView).navigate(R.id.action_nav_gallery_to_ticket_form, bundle);
            }
        });
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    static class TicketSliderAdapterViewHolder extends TicketSliderAdapter.ViewHolder {
        View itemView;
        ImageView imageViewBackground;
        TextView titleTextView, dateTextView, priceTextView;
        Button buttonBuy;

        public TicketSliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.item1);
            dateTextView = itemView.findViewById(R.id.item2);
            priceTextView = itemView.findViewById(R.id.priceeeeeee);
//            priceTextView = itemView.findViewById(R.id.priceeeeeee);
            buttonBuy = itemView.findViewById(R.id.buy_ticket);
            this.itemView = itemView;
        }
    }



}
