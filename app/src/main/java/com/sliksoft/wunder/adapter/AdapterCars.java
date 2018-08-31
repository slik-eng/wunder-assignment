package com.sliksoft.wunder.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sliksoft.wunder.R;
import com.sliksoft.wunder.model.Placemark;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public class AdapterCars extends RecyclerView.Adapter<AdapterCars.ViewHolder> {

    private List<Placemark> dataSet;


    public AdapterCars(List<Placemark> dataSet) {
        this.dataSet = dataSet;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_car,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Placemark placemark= dataSet.get(position);
        holder.bind(placemark);
    }

    @Override
    public int getItemCount() {
        return dataSet==null? 0 : dataSet.size();
    }

    public void changeDataSet(List<Placemark> results) {
        dataSet=results;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.row_address)
        TextView address;
        @BindView(R.id.row_name) TextView name;
        @BindView(R.id.row_status) TextView status;
        @BindView(R.id.row_vin) TextView vin;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(Placemark placemark) {

            vin.setText(placemark.getVin());
            address.setText(placemark.getAddress());
            name.setText(String.format(
                    Locale.getDefault(),
                    name.getContext().getString(R.string.formatted_name),placemark.getName(),
                        placemark.getEngineType(),placemark.getFuel()));

            status.setText(String.format(Locale.getDefault(),
                    status.getContext().getString(R.string.car_status),placemark.getInterior(),placemark.getExterior()));


        }
    }
}
