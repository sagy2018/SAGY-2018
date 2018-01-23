package com.example.jason.sagy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.onesignal.OneSignal;

public class Registration extends AppCompatActivity {

    Button register;
    TextView t2;
    EditText username,password;
    ProgressBar progressBa;
    Spinner spinner;
    private FirebaseAuth mAuth;
    ArrayAdapter<CharSequence> adapter;
    DatabaseReference databaseReference;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        spinner =(Spinner) findViewById(R.id.spinner1);
        adapter=ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        databaseReference=FirebaseDatabase.getInstance().getReference().child("users").push();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent!= null) {
                    Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "  " + "selected", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "  " + "selected", Toast.LENGTH_LONG).hashCode();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
                adddata();

            }
        });

    }

    private void adddata(){
        String user = username.getText().toString().trim();
        String scheme=spinner.getSelectedItem().toString().trim();

        if(!TextUtils.isEmpty(user)){
           String id = databaseReference.push().getKey();

          pojo pojo = new pojo(id,user,scheme);

            databaseReference.setValue(pojo);
            //databaseReference.setValue(user);



        }else {
            Toast.makeText(this,"Enter valid name",Toast.LENGTH_LONG).show();
        }
    }



    private void registerUser(){

        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(TextUtils.isEmpty(user)){
            username.setError("EMail is required");
            username.requestFocus();
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(user).matches()){
            username.setError("Please enter a valid EMail");
            username.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(pass)){
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
                    Intent intent=new Intent(Registration.this,Grid.class);
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
