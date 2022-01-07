package com.example.soa;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Items> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txt_name, txt_price, txt_qty;

        public ViewHolder(View view) {
            super(view);

            txt_name = (TextView) view.findViewById(R.id.txt_name);
            txt_price = (TextView) view.findViewById(R.id.txt_price);
            txt_qty = (TextView) view.findViewById(R.id.txt_qty);

        }
    }


    public CustomAdapter(ArrayList<Items> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txt_name.setText("Name = "+localDataSet.get(position).getName());
        holder.txt_price.setText("Price = "+localDataSet.get(position).getPrice());
        holder.txt_qty.setText("Quantity = "+localDataSet.get(position).getQty()+" "+localDataSet.get(position).getUnit());

    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

