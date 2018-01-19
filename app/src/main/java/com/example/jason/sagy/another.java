package com.example.jason.sagy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class another extends AppCompatActivity {
    ImageView iv1,iv2;
    ImageButton imb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        iv1=(ImageView) findViewById(R.id.moredetails);
        iv2=(ImageView) findViewById(R.id.mpdetails);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(another.this,anotherplus.class);
                startActivity(intent);
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(another.this,anotherplusplus.class);
                startActivity(in);
            }
        });
        imb=(ImageButton) findViewById(R.id.imageButton);
        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(another.this,Village.class);
                startActivity(intent);
            }
        });
    }
}
