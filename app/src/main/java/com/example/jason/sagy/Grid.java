package com.example.jason.sagy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Grid extends AppCompatActivity {
    LinearLayout l1,l2,l3,l4,l5,l6,l8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_grid);


        l1=(LinearLayout) findViewById(R.id.l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Grid.this,MP.class);
                startActivity(intent);
            }
        });
        l2=(LinearLayout) findViewById(R.id.im2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Grid.this,Village.class);
                startActivity(intent);
            }
        });
        l3=(LinearLayout) findViewById(R.id.i3);
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Grid.this,Notifications.class);
                startActivity(intent);
            }
        });
        l4=(LinearLayout) findViewById(R.id.i4);
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Grid.this,Schemes.class);
                startActivity(intent);
            }
        });
        l5=(LinearLayout) findViewById(R.id.sagy);
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Grid.this,Organ.class);
                startActivity(intent);
            }
        });
        l6=(LinearLayout) findViewById(R.id.gallery);
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Grid.this,Gallery.class);
                startActivity(intent);
            }
        });
        l8 = (LinearLayout)findViewById(R.id.im8);
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Grid.this, "Successfully logout!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Grid.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onBackPressed() {
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        }else {
            Intent intent = new Intent(Grid.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }


}
