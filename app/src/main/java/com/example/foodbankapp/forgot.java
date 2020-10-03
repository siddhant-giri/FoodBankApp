package com.example.foodbankapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    ImageButton resetbtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        emailpass=findViewById(R.id.editTextTextEmailAddress);
        resetbtn=findViewById(R.id.imageButton32);
        fAuth =  FirebaseAuth.getInstance();

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
                            }else{
                                Toast.makeText(forgot.this,"Error in sending password reset email !", Toast.LENGTH_SHORT).show();


                            }

                        }
                    });
                }
            }
        });

    }
}