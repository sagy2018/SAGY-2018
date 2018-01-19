package com.example.jason.sagy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Registration extends AppCompatActivity {

    Button register;
    TextView t2;
    EditText username,password;
    ProgressBar progressBa;
    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
        progressBa=(ProgressBar)findViewById(R.id.progressBar);
        username=(EditText)findViewById(R.id.editText4);
        password=(EditText)findViewById(R.id.editText5);
        register=(Button) findViewById(R.id.button2);
        t2=(TextView)findViewById(R.id.textView2);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent=new Intent(Registration.this,MainActivity.class);
                startActivity(intent);
            }

        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();

            }
        });
    }
    private void registerUser(){

        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(user.isEmpty()){
            username.setError("EMail is required");
            username.requestFocus();
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(user).matches()){
            username.setError("Please enter a valid EMail");
            username.requestFocus();
            return;
        }
        if(pass.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            return;
        }
        if(pass.length()<6){
            password.setError("Minimum length of password must be 6");
            password.requestFocus();
            return;
        }
        progressBa.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBa.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    finish();
                    Intent intent=new Intent(Registration.this,Selection.class);
                    Toast.makeText(Registration.this, "User Registration is Successfull", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(Registration.this, "You are already Registered", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}
