package com.example.pcspecsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {

    EditText setId_delete;
    Button setId_deleteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        setId_delete = findViewById(R.id.setId_delete);
        setId_deleteButton = findViewById(R.id.setId_deleteButton);

        setId_deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiLayer.deletePcSpecs(Integer.parseInt(setId_delete.getText().toString()));
                finish();
            }
        });
    }
}