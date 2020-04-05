package com.example.mobilszoft;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CitiesActivity extends AppCompatActivity implements CitiesView {

    private NestedScrollView nestedScrollView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.list_view);

        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("Athens");
        your_array_list.add("Paris");
        your_array_list.add("St. Louis");
        your_array_list.add("London");
        your_array_list.add("Stockholm");
        your_array_list.add("Berlin");
        your_array_list.add("Antwerp");
        your_array_list.add("Chamonix");
        your_array_list.add("St. Moritz");
        your_array_list.add("Amsterdam");
        your_array_list.add("Los Angeles");
        your_array_list.add("Oslo");
        your_array_list.add("Helsinki");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        listView.setAdapter(arrayAdapter);

    }

    @Override
    public void downloadCities() {

    }

    @Override
    public void saveCities() {

    }

    @Override
    public void showCities() {

    }

    @Override
    public void sendNotification() {

    }

    @Override
    public void calculateDistances() {

    }
}
