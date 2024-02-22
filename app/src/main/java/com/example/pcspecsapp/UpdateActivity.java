package com.example.pcspecsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText setId_update;
    Button setId_updateButton;
    Button updateButton;
    EditText updateName;
    EditText updateCpu;
    EditText updateGpu;
    EditText updateRam;
    EditText updateSsd;
    EditText updatePsu;
    EditText updateMb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        setId_update = findViewById(R.id.setId_update);
        setId_updateButton = findViewById(R.id.setId_updateButton);
        updateButton = findViewById(R.id.updateButton);
        updateName = findViewById(R.id.updateName);
        updateCpu = findViewById(R.id.updateCpu);
        updateGpu = findViewById(R.id.updateGpu);
        updateRam = findViewById(R.id.updateRam);
        updateSsd = findViewById(R.id.updateSsd);
        updatePsu = findViewById(R.id.updatePsu);
        updateMb = findViewById(R.id.updateMb);

        setId_updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PcSpecs pcSpecs = ApiLayer.getPcSpecsById(Integer.parseInt(setId_update.getText().toString()));
                updateName.setText(pcSpecs.getName());
                updateCpu.setText(pcSpecs.getCpu());
                updateGpu.setText(pcSpecs.getGpu());
                updateRam.setText(pcSpecs.getRam());
                updateSsd.setText(pcSpecs.getSsd());
                updatePsu.setText(pcSpecs.getPsu());
                updateMb.setText(pcSpecs.getMb());
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PcSpecs pcSpecs = new PcSpecs();
                pcSpecs.setId(Integer.parseInt(setId_update.getText().toString()));
                pcSpecs.setName(String.valueOf(updateName.getText()));
                pcSpecs.setCpu(String.valueOf(updateCpu.getText()));
                pcSpecs.setGpu(String.valueOf(updateGpu.getText()));
                pcSpecs.setRam(String.valueOf(updateRam.getText()));
                pcSpecs.setSsd(String.valueOf(updateSsd.getText()));
                pcSpecs.setPsu(String.valueOf(updatePsu.getText()));
                pcSpecs.setMb(String.valueOf(updateMb.getText()));

                ApiLayer.addPcSpecs(pcSpecs);
                finish();
            }
        });

    }
}