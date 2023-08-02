package com.example.labux.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labux.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<DataModel> mValues;
    private Context mContext;
    private ItemListener mListener;
    private View rootView;

    public RecyclerViewAdapter(Context context, ArrayList<DataModel> values, ItemListener itemListener, View rootView) {
        mValues = values;
        mContext = context;
        mListener = itemListener;
        this.rootView = rootView;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleTextView;
        public TextView dateTextView;
        public TextView priceTextView;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
        private DataModel item;
        public Button btnBuyTicket;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            titleTextView = v.findViewById(R.id.titleTextView);
            priceTextView = v.findViewById(R.id.priceTextView);
            dateTextView = v.findViewById(R.id.dateTextView);
            imageView = v.findViewById(R.id.imageView);
            btnBuyTicket = v.findViewById(R.id.buy_ticket);
        }

        public void setData(DataModel item) {
            this.item = item;
            titleTextView.setText(item.title);
            NumberFormat format = NumberFormat.getCurrencyInstance();
            format.setMaximumFractionDigits(0);
            format.setCurrency(Currency.getInstance("IDR"));

            String formatedPrice = format.format(item.getPrice());
            priceTextView.setText(String.valueOf(formatedPrice));
            dateTextView.setText(item.date);
            imageView.setImageResource(item.drawableSlider);;
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.setData(mValues.get(position));
        DataModel item = mValues.get(position);

        Button buttonBuy = holder.btnBuyTicket;
        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("selected", item);
                Navigation.findNavController(rootView).navigate(R.id.action_nav_gallery_to_ticket_form, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(DataModel item);
    }
}