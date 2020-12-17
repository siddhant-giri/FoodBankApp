package com.example.foodbankapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import maes.tech.intentanim.CustomIntent;


import android.annotation.SuppressLint;
import android.content.Intent;

import android.graphics.Bitmap;

import android.net.Uri;
import android.os.Bundle;


import android.provider.MediaStore;
import android.text.TextUtils;

import android.view.View;

import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;


public class foodform extends AppCompatActivity {
    //Variables
    EditText vname;
    EditText vnumber;
    EditText vquantity;
    EditText vpickup;
    EditText vdate;
    ImageButton sbtn, backbtn;
    Button camerabtn;
    Bitmap image;

    FirebaseDatabase rootNode;
    DatabaseReference reference,reference2;

    TextView test;
    ImageView testimg,photo;
    private StorageReference mStorageRef;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodform);

        mStorageRef = FirebaseStorage.getInstance().getReference();

        test = (TextView) findViewById(R.id.test);
        testimg = (ImageView) findViewById(R.id.testimg);

        Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("BitmapImage");

        String value = getIntent().getStringExtra("key");
        test.setText(""+value+"");
        testimg.setImageBitmap(bitmap);




        //form database
        //hooks to all xml elements
        vname = (EditText) findViewById(R.id.vname);
        vnumber = (EditText) findViewById(R.id.vnumber);
        vquantity = (EditText) findViewById(R.id.vqty);
        vpickup = (EditText)findViewById(R.id.vpickup);
        vdate = (EditText) findViewById(R.id.vdate);
        sbtn = (ImageButton) findViewById(R.id.sbtn);
        backbtn = (ImageButton) findViewById(R.id.backbtn);
        camerabtn = (Button) findViewById(R.id.capture);
        photo = (ImageView) findViewById(R.id.captureImg);

        camerabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera, 0);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodform.this, store.class);
                startActivity(intent);
                CustomIntent.customType(foodform.this, "fadein-to-fadeout");
            }
        });

        //save data to firebase on button click
        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("donations");


                //get all the values

                String pname = vname.getText().toString();
                String pnumber = vnumber.getText().toString();
                String pqty = vquantity.getText().toString();
                String ppickup = vpickup.getText().toString();
                String pdate = vdate.getText().toString();
                String pproduct = test.getText().toString();

                if(TextUtils.isEmpty(pname)){
                    Toast.makeText(foodform.this, "enter name please",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(pqty)){
                    Toast.makeText(foodform.this, "enter quantity please",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(pnumber)){
                    Toast.makeText(foodform.this, "enter number please",Toast.LENGTH_SHORT).show();
                    return;
                }



                if(TextUtils.isEmpty(ppickup)){
                    Toast.makeText(foodform.this, "enter number of packets please",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(pdate)){
                    Toast.makeText(foodform.this, "enter address please",Toast.LENGTH_SHORT).show();
                    return;
                }



                FormHelperClass helperClass = new FormHelperClass(pname, pnumber, pqty, ppickup,pdate,pproduct);

                reference.child(pnumber).setValue(helperClass);

                upload();

                Toast.makeText(foodform.this, "Thank you!! for donation :)", Toast.LENGTH_SHORT).show();

                vname.setText("");
                vnumber.setText("");
                vquantity.setText("");
                vpickup.setText("");
                vdate.setText("");
                photo.setImageBitmap(null);




            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK) {
            image = (Bitmap) data.getExtras().get("data");
            photo.setImageBitmap(image);
        }
    }

    private void upload() {
//        final ProgressBar p = findViewById(R.id.progressbar);
//
//        p.setVisibility(View.VISIBLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        final String random = UUID.randomUUID().toString();
        StorageReference imageRef = mStorageRef.child("image/" + random);

        byte[] b = stream.toByteArray();
        imageRef.putBytes(b)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                        taskSnapshot.getMetadata().getReference().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Uri downloadUri = uri;
                                String imagelink = downloadUri.toString();
                                reference2 = FirebaseDatabase.getInstance().getReference();
                                String uniqueId = reference2.push().getKey();
                                reference2 = rootNode.getReference("imageLinks");
                                reference2.child(uniqueId).setValue(imagelink);

                            }
                        });

//                        Toast.makeText(foodform.this, "Photo Uploaded", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                        Toast.makeText(foodform.this, "Upload Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent(foodform.this, store.class);
        startActivity(intent);
        CustomIntent.customType(foodform.this, "fadein-to-fadeout");
    }
}