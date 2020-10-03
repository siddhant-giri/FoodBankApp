package com.example.foodbankapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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

public class register extends AppCompatActivity {

    EditText mFullname, mEmail, mPassword,mConfirm;
    ImageButton signupbtn;
    TextView loginbtn;
    FirebaseAuth fAuth;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullname = findViewById(R.id.editTextTextPersonName2);
        mEmail = findViewById(R.id.editTextTextEmailAddress2);
        mPassword = findViewById(R.id.editTextTextPassword);
        mConfirm =  findViewById(R.id.editTextTextPassword2);
        signupbtn = findViewById(R.id.imageButton);
        loginbtn = findViewById(R.id.textView2);
        progressbar = findViewById(R.id.progressBar);

        fAuth =  FirebaseAuth.getInstance();

        /*if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
            finish();

        }
        */

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String name= mFullname.getText().toString().trim();

                if(TextUtils.isEmpty(name)){
                    mFullname.setError("Please enter full name");
                }

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

                progressbar.setVisibility(View.VISIBLE);

                // register the user in firebase
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(register.this,"You have registered",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),register.class));

                        }else{
                            Toast.makeText(register.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressbar.setVisibility(View.GONE);

                        }

                    }
                });


            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });

    }
}