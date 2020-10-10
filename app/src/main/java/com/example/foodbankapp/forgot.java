package com.example.foodbankapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import android.os.Bundle;

public class forgot extends AppCompatActivity {

    private EditText emailpass;
    ImageButton resetbtn, back;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        emailpass=findViewById(R.id.editTextTextEmailAddress);
        resetbtn=findViewById(R.id.imageButton32);
        back = findViewById(R.id.imageButton7);
        fAuth =  FirebaseAuth.getInstance();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(forgot.this, login.class);
                startActivity(intent);
                CustomIntent.customType(forgot.this, "up-to-bottom");
            }
        });


        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String useremail = emailpass.getText().toString().trim();

                if(useremail.equals("")){
                    Toast.makeText(forgot.this, "Please enter your registered email-iD !", Toast.LENGTH_SHORT).show();
                }else{
                    fAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(forgot.this,"Password Reset email sent !", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(forgot.this, login.class));
                                CustomIntent.customType(forgot.this, "up-to-bottom");
                            }else{
                                Toast.makeText(forgot.this,"Error in sending password reset email !", Toast.LENGTH_SHORT).show();


                            }

                        }
                    });
                }
            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        Intent intent = new Intent(forgot.this, login.class);
        startActivity(intent);
        CustomIntent.customType(forgot.this, "up-to-bottom");
    }
}