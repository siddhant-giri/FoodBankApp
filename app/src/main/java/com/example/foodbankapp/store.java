package com.example.foodbankapp;


import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;
import android.os.Bundle;

public class store extends AppCompatActivity {

    ImageButton ricebtn, flourbtn, sugarbtn, oilbtn, vegbtn, milkbtn, dalbtn, contactbtn, logout;
    TextView ricetxt, flourtxt, sugartxt, oiltxt, vegtxt, milktxt, daltxt;
    ImageView riceimg, flourimg,  sugarimg, oilimg, vegimg, milkimg, dalimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        logout = (ImageButton) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(store.this, login.class);
                startActivity(intent);
                CustomIntent.customType(store.this, "right-to-left");
            }
        });


        sugarbtn = (ImageButton) findViewById(R.id.sugarbtn);
        sugartxt = (TextView) findViewById(R.id.sugartxt);
        sugarimg = (ImageView) findViewById(R.id.sugarimg);


        sugarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = sugartxt.getText().toString();
                sugarimg.buildDrawingCache();
                Bitmap bitmap = sugarimg.getDrawingCache();
                Intent intent = new Intent(store.this, foodform.class);
                intent.putExtra("key", value);
                intent.putExtra("BitmapImage", bitmap);
                startActivity(intent);
                CustomIntent.customType(store.this, "fadein-to-fadeout");


            }
        });


        flourbtn = (ImageButton) findViewById(R.id.flourbtn);
        flourtxt = (TextView) findViewById(R.id.flourtxt);
        flourimg = (ImageView) findViewById(R.id.flourimg);


        flourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = flourtxt.getText().toString();
                flourimg.buildDrawingCache();
                Bitmap bitmap = flourimg.getDrawingCache();
                Intent intent = new Intent(store.this, foodform.class);
                intent.putExtra("key", value);
                intent.putExtra("BitmapImage", bitmap);
                startActivity(intent);
                CustomIntent.customType(store.this, "fadein-to-fadeout");


            }
        });


        ricebtn = (ImageButton) findViewById(R.id.ricebtn);
        ricetxt = (TextView) findViewById(R.id.ricetxt);
        riceimg = (ImageView) findViewById(R.id.riceimg);


        ricebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = ricetxt.getText().toString();
                riceimg.buildDrawingCache();
                Bitmap bitmap = riceimg.getDrawingCache();
                Intent intent = new Intent(store.this, foodform.class);
                intent.putExtra("key", value);
                intent.putExtra("BitmapImage", bitmap);
                startActivity(intent);
                CustomIntent.customType(store.this, "fadein-to-fadeout");


            }
        });

        oilbtn = (ImageButton) findViewById(R.id.oilbtn);
        oiltxt = (TextView) findViewById(R.id.oiltxt);
        oilimg = (ImageView) findViewById(R.id.oilimg);


        oilbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = oiltxt.getText().toString();
                oilimg.buildDrawingCache();
                Bitmap bitmap = oilimg.getDrawingCache();
                Intent intent = new Intent(store.this, foodform.class);
                intent.putExtra("key", value);
                intent.putExtra("BitmapImage", bitmap);
                startActivity(intent);
                CustomIntent.customType(store.this, "fadein-to-fadeout");

            }
        });

        milkbtn = (ImageButton) findViewById(R.id.milkbtn);
        milktxt = (TextView) findViewById(R.id.milktxt);
        milkimg = (ImageView) findViewById(R.id.milkimg);


        milkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = milktxt.getText().toString();
                milkimg.buildDrawingCache();
                Bitmap bitmap = milkimg.getDrawingCache();
                Intent intent = new Intent(store.this, foodform.class);
                intent.putExtra("key", value);
                intent.putExtra("BitmapImage", bitmap);
                startActivity(intent);
                CustomIntent.customType(store.this, "fadein-to-fadeout");


            }
        });

        vegbtn = (ImageButton) findViewById(R.id.vegbtn);
        vegtxt = (TextView) findViewById(R.id.vegtxt);
        vegimg = (ImageView) findViewById(R.id.vegimg);


        vegbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = vegtxt.getText().toString();
                vegimg.buildDrawingCache();
                Bitmap bitmap = vegimg.getDrawingCache();
                Intent intent = new Intent(store.this, foodform.class);
                intent.putExtra("key", value);
                intent.putExtra("BitmapImage", bitmap);
                startActivity(intent);
                CustomIntent.customType(store.this, "fadein-to-fadeout");


            }
        });


        dalbtn = (ImageButton) findViewById(R.id.dalbtn);
        daltxt = (TextView) findViewById(R.id.daltxt);
        dalimg = (ImageView) findViewById(R.id.dalimg);


        dalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = daltxt.getText().toString();
                dalimg.buildDrawingCache();
                Bitmap bitmap = dalimg.getDrawingCache();
                Intent intent = new Intent(store.this, foodform.class);
                intent.putExtra("key", value);
                intent.putExtra("BitmapImage", bitmap);
                startActivity(intent);
                CustomIntent.customType(store.this, "fadein-to-fadeout");


            }
        });


        contactbtn = (ImageButton) findViewById(R.id.contactbtn);

        contactbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(store.this, contact.class);
                startActivity(intent);
                CustomIntent.customType(store.this, "left-to-right");
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent(store.this, onboard.class);
        startActivity(intent);
        CustomIntent.customType(store.this, "right-to-left");
    }
}