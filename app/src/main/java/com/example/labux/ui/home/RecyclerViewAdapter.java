package com.example.labux.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labux.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<DataModel> mValues;
    private Context mContext;
    private ItemListener mListener;

    public RecyclerViewAdapter(Context context, ArrayList<DataModel> values, ItemListener itemListener) {
        mValues = values;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleTextView;
        public TextView dateTextView;
        public TextView priceTextView;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
        private DataModel item;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            titleTextView = v.findViewById(R.id.titleTextView);
            priceTextView = v.findViewById(R.id.priceTextView);
            dateTextView = v.findViewById(R.id.dateTextView);
            imageView = v.findViewById(R.id.imageView);
        }

        public void setData(DataModel item) {
            this.item = item;
            titleTextView.setText(item.title);
            priceTextView.setText(String.valueOf(item.price));
            dateTextView.setText(item.date);
            imageView.setImageResource(item.drawable);;
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
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(DataModel item);
    }
}