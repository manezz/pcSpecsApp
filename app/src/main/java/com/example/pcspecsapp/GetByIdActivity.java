package com.example.pcspecsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GetByIdActivity extends AppCompatActivity {

    EditText setId_getById;
    Button setId_getByIdButton;
    TextView getByIdId;
    TextView getByIdName;
    TextView getByIdCpu;
    TextView getByIdGpu;
    TextView getByIdRam;
    TextView getByIdSsd;
    TextView getByIdPsu;
    TextView getByIdMb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_by_id);

        setId_getById = findViewById(R.id.setId_getById);
        setId_getByIdButton = findViewById(R.id.setId_getByIdButton);
        getByIdId = findViewById(R.id.getByIdId);
        getByIdName = findViewById(R.id.getByIdName);
        getByIdCpu = findViewById(R.id.getByIdCpu);
        getByIdGpu = findViewById(R.id.getByIdGpu);
        getByIdRam = findViewById(R.id.getByIdRam);
        getByIdSsd = findViewById(R.id.getByIdSsd);
        getByIdPsu = findViewById(R.id.getByIdPsu);
        getByIdMb = findViewById(R.id.getByIdMb);

        setId_getByIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PcSpecs pcSpecs = ApiLayer.getPcSpecsById(Integer.parseInt(setId_getById.getText().toString()));
                getByIdId.setText("Id: " + String.valueOf(pcSpecs.getId()));
                getByIdName.setText("Name: " + pcSpecs.getName());
                getByIdCpu.setText("CPU: " + pcSpecs.getCpu());
                getByIdGpu.setText("GPU: " + pcSpecs.getGpu());
                getByIdRam.setText("RAM: " + pcSpecs.getRam());
                getByIdSsd.setText("SSD: " + pcSpecs.getSsd());
                getByIdPsu.setText("PSU: " + pcSpecs.getPsu());
                getByIdMb.setText("MB: " + pcSpecs.getMb());
            }
        });
    }
}