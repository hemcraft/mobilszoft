package com.example.mobilszoft.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobilszoft.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<ListElementCity> citiesData;
    LayoutInflater layoutInflater;
    ListElementCity citiesModel;
 
    public CustomAdapter(Context context, ArrayList<ListElementCity> citiesData) {
        this.context = context;
        this.citiesData = citiesData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    @Override
    public int getCount() {
        return citiesData.size();
    }
 
    @Override
    public Object getItem(int i) {
        return citiesData.get(i);
    }
 
    @Override
    public long getItemId(int i) {
        return citiesData.get(i).getId();
    }
 
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
 
        View rowView = view;
        if (rowView==null) {
            rowView = layoutInflater.inflate(R.layout.city_row, null, true);
        }
            //link views
            ImageView countryFlagIv = rowView.findViewById(R.id.countryFlagIv);
            TextView cityNameTv = rowView.findViewById(R.id.cityNameTv);
            TextView countryTv = rowView.findViewById(R.id.countryTv);
            TextView distanceTv = rowView.findViewById(R.id.distanceTv);
 
            citiesModel = citiesData.get(position);
 
            countryFlagIv.setImageResource(citiesModel.getImage());
            cityNameTv.setText(citiesModel.getName());
            countryTv.setText(citiesModel.getCountry());
            distanceTv.setText("Distance : " + citiesModel.getDistance() + "Km");
 
        return rowView;
    }
}