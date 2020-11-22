package com.example.foodbankapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class cameraCapture extends AppCompatActivity {

    ImageButton btnCaptureImage, backbtn;
    ImageView imageDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_capture);


        backbtn = (ImageButton) findViewById(R.id.imageButton);
        btnCaptureImage= (ImageButton) findViewById(R.id.btn_capture);
        imageDisplay=(ImageView)findViewById(R.id.imageCapture);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cameraCapture.this, store.class);
                startActivity(intent);
                CustomIntent.customType(cameraCapture.this, "left-to-right");
            }
        });

        btnCaptureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageDisplay.setImageBitmap(bitmap);
    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent(cameraCapture.this, store.class);
        startActivity(intent);
        CustomIntent.customType(cameraCapture.this, "right-to-left");
    }

}