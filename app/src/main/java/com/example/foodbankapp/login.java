package com.example.foodbankapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;


import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.os.Bundle;

public class login extends AppCompatActivity {

    public TextView create;
    TextView forgot;
    EditText mEmail, mPassword;
    ImageButton loginbtn, back;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.editTextTextEmailAddress2);
        mPassword = findViewById(R.id.editTextTextPassword);
        loginbtn = findViewById(R.id.imageButton5);
        progressBar = findViewById(R.id.progressBar2);
        fAuth = FirebaseAuth.getInstance();
        create=findViewById(R.id.link);
        forgot=findViewById(R.id.textView);
        back = findViewById(R.id.imageButton6);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                CustomIntent.customType(login.this, "right-to-left");
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), register.class);
                startActivity(intent);
                CustomIntent.customType(login.this, "up-to-bottom");
                Toast.makeText(login.this, "Moving to Signup", Toast.LENGTH_SHORT).show();
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), forgot.class);
                startActivity(intent);
                CustomIntent.customType(login.this, "bottom-to-up");
                Toast.makeText(login.this, "Reset Your Password !", Toast.LENGTH_SHORT).show();
            }
        });


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Please enter email-id");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Please enter password");
                    return;
                }

                if(password.length()<6){
                    mPassword.setError("Password must be >= 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);


                //authenticate the user
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(login.this,"Logged in successfully!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),onboard.class));
                            CustomIntent.customType(login.this, "left-to-right");
                        }else{
                            Toast.makeText(login.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }

                });




            }
        });


    }

    @Override
    public void finish() {
        super.finish();
        Intent intent= new Intent(login.this, MainActivity.class);
        startActivity(intent);
        CustomIntent.customType(login.this, "right-to-left");
    }
}