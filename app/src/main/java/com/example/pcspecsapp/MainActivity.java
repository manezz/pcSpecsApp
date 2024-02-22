package com.example.pcspecsapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button getAllPcSpecs;
    Button getPcSpecs;
    Button addPcSpecs;
    Button updatePcSpecs;
    Button deletePcSpecs;
    ActivityResultLauncher<Intent> secondActivityLauncher;
    ActivityResultLauncher<Intent> thirdActivityLauncher;
    ActivityResultLauncher<Intent> fourthActivityLauncher;
    ActivityResultLauncher<Intent> fifthActivityLauncher;
    ActivityResultLauncher<Intent> sixthActivityLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAllPcSpecs = findViewById(R.id.getAllPcSpecs);
        getPcSpecs = findViewById(R.id.getPcSpecs);
        addPcSpecs = findViewById(R.id.addPcSpecs);
        updatePcSpecs = findViewById(R.id.updatePcSpecs);
        deletePcSpecs = findViewById(R.id.deletePcSpecs);

        secondActivityLauncher = registerForActivityResult
                (
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>()
                        {
                            @Override
                            public void onActivityResult(ActivityResult result)
                            {
                                if(result.getResultCode() == Activity.RESULT_OK)
                                {
                                    Intent intent = result.getData();
                                }
                            }
                        }
                );
        thirdActivityLauncher = registerForActivityResult
                (
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>()
                        {
                            @Override
                            public void onActivityResult(ActivityResult result)
                            {
                                if(result.getResultCode() == Activity.RESULT_OK)
                                {
                                    Intent intent = result.getData();
                                }
                            }
                        }
                );
        fourthActivityLauncher = registerForActivityResult
                (
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>()
                        {
                            @Override
                            public void onActivityResult(ActivityResult result)
                            {
                                if(result.getResultCode() == Activity.RESULT_OK)
                                {
                                    Intent intent = result.getData();
                                }
                            }
                        }
                );
        fifthActivityLauncher = registerForActivityResult
                (
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>()
                        {
                            @Override
                            public void onActivityResult(ActivityResult result)
                            {
                                if(result.getResultCode() == Activity.RESULT_OK)
                                {
                                    Intent intent = result.getData();
                                }
                            }
                        }
                );
        sixthActivityLauncher = registerForActivityResult
                (
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>()
                        {
                            @Override
                            public void onActivityResult(ActivityResult result)
                            {
                                if(result.getResultCode() == Activity.RESULT_OK)
                                {
                                    Intent intent = result.getData();
                                }
                            }
                        }
                );

        getPcSpecs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetByIdActivity.class);
                thirdActivityLauncher.launch(intent);
            }
        });

        addPcSpecs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                fourthActivityLauncher.launch(intent);
            }
        });

        updatePcSpecs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                fifthActivityLauncher.launch(intent);
            }
        });

        deletePcSpecs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
                sixthActivityLauncher.launch(intent);
            }
        });

    }
}