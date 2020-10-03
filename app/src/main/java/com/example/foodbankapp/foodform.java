package com.example.foodbankapp;

import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;

public class foodform extends AppCompatActivity {

    //Variables
    EditText vname;
    EditText vnumber;
    EditText vquantity;
    EditText vpackets;
    EditText vaddress;
    EditText vpeople;
    ImageButton sbtn, backbtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    TextView test;
    ImageView testimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodform);

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
        vpackets = (EditText)findViewById(R.id.vpkts);
        vaddress = (EditText) findViewById(R.id.vadd);
        vpeople = (EditText) findViewById(R.id.vpeople);
        sbtn = (ImageButton) findViewById(R.id.sbtn);
        backbtn = (ImageButton) findViewById(R.id.backbtn);

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
                reference = rootNode.getReference("form");


                //get all the values

                String pname = vname.getText().toString();
                String pnumber = vnumber.getText().toString();
                String pqty = vquantity.getText().toString();
                String ppkts = vpackets.getText().toString();
                String padd = vaddress.getText().toString();
                String ppeople = vpeople.getText().toString();
                String pproduct = test.getText().toString();

                if(TextUtils.isEmpty(pname)){
                    Toast.makeText(foodform.this, "enter name please",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(pnumber)){
                    Toast.makeText(foodform.this, "enter number please",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(pqty)){
                    Toast.makeText(foodform.this, "enter quantity please",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(ppkts)){
                    Toast.makeText(foodform.this, "enter number of packets please",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(padd)){
                    Toast.makeText(foodform.this, "enter address please",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(ppeople)){
                    Toast.makeText(foodform.this, "enter no. of people please",Toast.LENGTH_SHORT).show();
                    return;
                }

                FormHelperClass helperClass = new FormHelperClass(pname, pnumber, pqty, ppkts,padd,ppeople,pproduct);

                reference.child(pnumber).setValue(helperClass);

                Toast.makeText(foodform.this, "Successfully data added", Toast.LENGTH_SHORT).show();

                vname.setText("");
                vnumber.setText("");
                vquantity.setText("");
                vpackets.setText("");
                vaddress.setText("");
                vpeople.setText("");



            }
        });


    }
    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(foodform.this, "fadein-to-fadeout");
    }
}