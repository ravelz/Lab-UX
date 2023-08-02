package com.example.labux.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.example.labux.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class DoubleSliderAdapter extends SliderViewAdapter<DoubleSliderAdapter.DoubleSliderAdapterViewHolder> {
    private final List<DataModel> mSliderItems;
    private final List<DataModel> mSliderItems1;
    private View rootView;

    public DoubleSliderAdapter(View rootView, ArrayList<DataModel> sliderDataArrayList, ArrayList<DataModel> mSliderItems1) {
        this.mSliderItems = sliderDataArrayList;
        this.mSliderItems1 = mSliderItems1;
        this.rootView = rootView;

    }

    @Override
    public DoubleSliderAdapter.DoubleSliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.double_slider_item, null);
        return new DoubleSliderAdapter.DoubleSliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(DoubleSliderAdapter.DoubleSliderAdapterViewHolder viewHolder, final int position) {
        DataModel item = mSliderItems.get(position);
        viewHolder.imageViewBackground.setImageResource(item.getDrawableSlider());
        viewHolder.textViewTitle.setText(item.getTitle());
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("IDR"));

        String formatedPrice = format.format(item.getPrice());
        viewHolder.textViewPrice.setText(formatedPrice);
        viewHolder.textViewDate.setText(item.getDate());
        viewHolder.buttonBuyTicket.setText("Buy Ticket");

        viewHolder.imageViewBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("selected", item);
                Navigation.findNavController(rootView).navigate(R.id.action_nav_home_to_ticket_form, bundle);
            }
        });
        DataModel item1 = mSliderItems1.get(position);
        viewHolder.imageViewBackground1.setImageResource(item1.getDrawableSlider());
        viewHolder.textViewTitle1.setText(item1.getTitle());

        String formatedPrice1 = format.format(item1.getPrice());
        viewHolder.textViewPrice1.setText(formatedPrice1);
        viewHolder.textViewDate1.setText(item1.getDate());
        viewHolder.imageViewBackground1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("selected", item1);
                Navigation.findNavController(rootView).navigate(R.id.action_nav_home_to_ticket_form, bundle);
            }
        });
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    static class DoubleSliderAdapterViewHolder extends DoubleSliderAdapter.ViewHolder {
        View itemView;
        ImageView imageViewBackground;
        ImageView imageViewBackground1;
        TextView textViewTitle, textViewTitle1, textViewPrice, textViewPrice1, textViewDate, textViewDate1;
        Button buttonBuyTicket,buttonBuyTicket1;

        public DoubleSliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.imageView);
            imageViewBackground1 = itemView.findViewById(R.id.imageView1);
            textViewTitle = itemView.findViewById(R.id.titleTextView);
            textViewTitle1 = itemView.findViewById(R.id.titleTextView1);

            textViewPrice = itemView.findViewById(R.id.priceTextView);
            textViewPrice1 = itemView.findViewById(R.id.priceTextView1);

            textViewDate = itemView.findViewById(R.id.dateTextView);
            textViewDate1 = itemView.findViewById(R.id.dateTextView1);

            buttonBuyTicket = itemView.findViewById(R.id.buy_ticket);
            buttonBuyTicket1 = itemView.findViewById(R.id.buy_ticket1);
            this.itemView = itemView;
        }
    }
}