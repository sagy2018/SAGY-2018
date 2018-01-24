package com.example.jason.sagy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageOpenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_open);

        Bundle bundle = getIntent().getExtras();

        String url = bundle != null ? bundle.getString("URL") : "";

        Picasso.with(ImageOpenActivity.this)
                .load(url)
                .fit()
                .into((ImageView)findViewById(R.id.open_imageView));
    }
}
