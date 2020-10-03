package com.example.foodbankapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


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
    ImageButton loginbtn;
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

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), register.class);
                startActivity(intent);

                Toast.makeText(login.this, "Moving to Signup", Toast.LENGTH_SHORT).show();
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), forgot.class);
                startActivity(intent);

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
                        }else{
                            Toast.makeText(login.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }

                });


            }
        });
    }
}