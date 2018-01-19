package com.example.jason.sagy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class num2 extends AppCompatActivity {
    ImageView imview;
    TextView textView;
    Button click;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num2);
        textView=(TextView) findViewById(R.id.textView10);
        click=(Button)findViewById(R.id.button9);
        close=(Button)findViewById(R.id.button10);
        click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            click.setVisibility(View.GONE);
                textView.setText(
                        "Name                      : Smt. Sasikala " +
                                                     "Pushpa\n" +
                        "Adopted village           : Pudupatti gram panchayat in pappireddipatti sub taluk \n" +
                        "District                  :Dharmapuri\n" +
                        "Educational qualifications: B.A. (English literature),M.A. (public administration),Diploma in business administration\n" +
                        "Elected from              :    tamilnadu\n" +
                        "Party name                :All India Anna Dravidian Munnetra Kalagam\n" +
                        "Positions held            : Joint secretary, Women Wing, AIADMK,2009,Deputy secretary, Youth Brigade wing, AIADMK,2010;Secretary, women wing, AIADMK,2013;\n" +
                        "Date of birth             :22 may,1976\n" +
                        "Member of                 :Rajya Sabha \n");






            }

        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(num2.this,More.class);
                startActivity(intent);
            }
        });






    }
}
