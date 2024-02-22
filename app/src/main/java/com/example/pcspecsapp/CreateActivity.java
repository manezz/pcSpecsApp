package com.example.pcspecsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateActivity extends AppCompatActivity {

    Button createButton;
    EditText createId;
    EditText createName;
    EditText createCpu;
    EditText createGpu;
    EditText createRam;
    EditText createSsd;
    EditText createPsu;
    EditText createMb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        createButton = findViewById(R.id.createButton);
        createName = findViewById(R.id.createName);
        createCpu = findViewById(R.id.createCpu);
        createGpu = findViewById(R.id.createGpu);
        createRam = findViewById(R.id.createRam);
        createSsd = findViewById(R.id.createSsd);
        createPsu = findViewById(R.id.createPsu);
        createMb = findViewById(R.id.createMb);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PcSpecs pcSpecs = new PcSpecs();
                pcSpecs.setName(String.valueOf(createName.getText()));
                pcSpecs.setCpu(String.valueOf(createCpu.getText()));
                pcSpecs.setGpu(String.valueOf(createGpu.getText()));
                pcSpecs.setRam(String.valueOf(createRam.getText()));
                pcSpecs.setSsd(String.valueOf(createSsd.getText()));
                pcSpecs.setPsu(String.valueOf(createPsu.getText()));
                pcSpecs.setMb(String.valueOf(createMb.getText()));

//                pcSpecs.name = String.valueOf(createName.getText());
//                pcSpecs.cpu = String.valueOf(createCpu.getText());
//                pcSpecs.gpu = String.valueOf(createGpu.getText());
//                pcSpecs.ssd = String.valueOf(createSsd.getText());
//                pcSpecs.psu = String.valueOf(createPsu.getText());
//                pcSpecs.mb = String.valueOf(createRam.getText());

                ApiLayer.addPcSpecs(pcSpecs);
                //finish();
            }
        });
    }
}