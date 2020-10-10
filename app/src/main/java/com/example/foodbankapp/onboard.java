package com.example.foodbankapp;

import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class onboard extends AppCompatActivity {

    ImageButton proceed, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);

        proceed = (ImageButton) findViewById(R.id.imageButton2);
        back = (ImageButton) findViewById(R.id.imageButton8);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(onboard.this, login.class);
                startActivity(intent);
                CustomIntent.customType(onboard.this, "right-to-left");
            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(onboard.this, store.class);
                startActivity(intent);
                CustomIntent.customType(onboard.this, "fadein-to-fadeout");
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent(onboard.this, login.class);
        startActivity(intent);
        CustomIntent.customType(onboard.this, "right-to-left");
    }
}