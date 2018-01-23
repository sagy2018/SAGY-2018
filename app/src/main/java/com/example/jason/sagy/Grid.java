package com.example.jason.sagy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Grid extends AppCompatActivity {
    LinearLayout l1,l2,l3,l4,l5,l6;
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



    }



}
