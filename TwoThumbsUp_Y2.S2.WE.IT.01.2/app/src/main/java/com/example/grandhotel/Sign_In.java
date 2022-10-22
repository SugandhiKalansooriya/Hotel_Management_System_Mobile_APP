package com.example.grandhotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_In extends AppCompatActivity {

    private EditText et_email, et_password;
    private TextView textView2;
    private Button Sign_in_btn;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        textView2 = findViewById(R.id.textView2);
        Sign_in_btn = findViewById(R.id.Sign_in_btn);
        mAuth = FirebaseAuth.getInstance();

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Sign_In.this, Register.class));
            }
        });

        Sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String email = et_email.getText().toString();
        String pass = et_password.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!pass.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(Sign_In.this, "Login Successfully !!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Sign_In.this, MainActivity3.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Sign_In.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                et_password.setError("Empty Fields Are not Allowed");
            }
        } else if (email.isEmpty()) {
            et_email.setError("Empty Fields Are not Allowed");
        } else {
            et_email.setError("Pleas Enter Correct Email");
        }

    }
}