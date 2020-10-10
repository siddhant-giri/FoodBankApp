package com.example.foodbankapp;

import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class contact extends AppCompatActivity {

    ImageButton storebtn, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        logout = (ImageButton) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contact.this, login.class);
                startActivity(intent);
                CustomIntent.customType(contact.this, "fadeout-to-fadein");
            }
        });

        storebtn = (ImageButton) findViewById(R.id.storebtn);

        storebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contact.this, store.class);
                startActivity(intent);
                CustomIntent.customType(contact.this, "right-to-left");

            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent(contact.this, store.class);
        startActivity(intent);
        CustomIntent.customType(contact.this, "right-to-left");
    }
}