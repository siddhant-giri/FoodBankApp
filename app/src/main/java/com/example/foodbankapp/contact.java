package com.example.foodbankapp;

import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class contact extends AppCompatActivity {

     Button btn;
     TextView textView;
     FusedLocationProviderClient fusedLocationProviderClient;

    ImageButton storebtn, logout, cambtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        cambtn = (ImageButton) findViewById(R.id.imageButton23);

        fusedLocationProviderClient = (FusedLocationProviderClient) LocationServices.getFusedLocationProviderClient(this);
        btn = (Button) findViewById(R.id.location_btn);
        textView = (TextView) findViewById(R.id.location_text);

        cambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contact.this, cameraCapture.class);
                startActivity(intent);
                CustomIntent.customType(contact.this, "right-to-left");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                        fusedLocationProviderClient.getLastLocation()
                                .addOnSuccessListener(new OnSuccessListener<Location>() {
                                    @Override
                                    public void onSuccess(Location location) {

                                        if (location != null){
                                            Double lat = location.getLatitude();
                                            Double longt = location.getLongitude();

                                            textView.setText("Latitude : "+lat+", Longitude : "+longt);
                                            Toast.makeText(contact.this, "Success", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }else {
                        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

                    }
                }
            }
        });

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