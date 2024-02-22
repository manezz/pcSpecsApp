package com.example.pcspecsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class GetAllActivity extends AppCompatActivity {

    List<PcSpecs> pcSpecsList;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all);

        listView = findViewById(R.id.listView);

        pcSpecsList = ApiLayer.getAllPcSpecs();

        fillListView();
    }

    public void fillListView() {
        CustomAdapter myCustomAdapter = new CustomAdapter(GetAllActivity.this, pcSpecsList);
        listView.setAdapter(myCustomAdapter);

    }
}