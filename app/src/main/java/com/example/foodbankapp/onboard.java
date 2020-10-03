package com.example.foodbankapp;

import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class onboard extends AppCompatActivity {

    ImageButton proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);

        proceed = (ImageButton) findViewById(R.id.imageButton2);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(onboard.this, store.class);
                startActivity(intent);
                CustomIntent.customType(onboard.this, "fadein-to-fadeout");
            }
        });
    }
}