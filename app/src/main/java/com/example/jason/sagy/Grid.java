package com.example.jason.sagy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Grid extends AppCompatActivity implements ViewPagerEx.OnPageChangeListener {
    LinearLayout l1, l2, l3, l4, l5, l6,l7,l8;
    private AQuery aq;
    private SliderLayout Slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        aq = new AQuery(getApplicationContext());
        ActionSlide();


        l1 = (LinearLayout) findViewById(R.id.l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Grid.this, MP.class);
                startActivity(intent);
            }
        });
        l2 = (LinearLayout) findViewById(R.id.im2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Grid.this, Village.class);
                startActivity(intent);
            }
        });
        l3 = (LinearLayout) findViewById(R.id.i3);
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Grid.this, Notifications.class);
                startActivity(intent);
            }
        });
        l4 = (LinearLayout) findViewById(R.id.i4);
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Grid.this, Schemes.class);
                startActivity(intent);
            }
        });
        l5 = (LinearLayout) findViewById(R.id.sagy);
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Grid.this, Organ.class);
                startActivity(intent);
            }
        });
        l6 = (LinearLayout) findViewById(R.id.gallery);
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Grid.this, Gallery.class);
                startActivity(intent);
            }
        });
        l7 = (LinearLayout) findViewById(R.id.im7);
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Grid.this,TeamActivity .class);
                startActivity(intent);
            }
        });
        l8 = (LinearLayout) findViewById(R.id.im8);
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Grid.this, "Successfully logout!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Grid.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }

    private void ActionSlide() {
        String url = "http://aaleswarayuga.96.lt/category.php";
        ProgressDialog progress = new ProgressDialog(Grid.this);
        progress.setMessage("Loading...");
        progress.setCancelable(false);

        //Image Slider
        Slider = (SliderLayout) findViewById(R.id.slider);
        Slider.setPresetTransformer(SliderLayout.Transformer.Default);
        Slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        Slider.setCustomAnimation(new DescriptionAnimation());
        Slider.setDuration(4000);
        Slider.addOnPageChangeListener((ViewPagerEx.OnPageChangeListener) this);

        aq.progress(progress).ajax(url, String.class, new AjaxCallback<String>() {

            @Override
            public void callback(String url, String object, AjaxStatus status) {
                if (object != null) {
                    try {
                        JSONObject json = new JSONObject(object);
                        JSONArray b = json.getJSONArray("category");
                        ArrayList<HashMap<String, String>> slideList = new ArrayList<>();
                        for (int i = 0; i < b.length(); i++) {
                            JSONObject a = b.getJSONObject(i);
                            String slide = a.getString("url");

                            HashMap<String, String> ss = new HashMap<>();
                            // adding each child node to HashMap key => value
                            ss.put("", slide);
                            // menambahkan data ke list
                            slideList.add(ss);

                            for (String name : ss.keySet()) {

                                DefaultSliderView sliderView = new DefaultSliderView((Grid.this));
                                sliderView.image(ss.get(name))
                                        .setScaleType(BaseSliderView.ScaleType.Fit);

//                                Slider.addSlider(textSliderView);
                                Slider.addSlider(sliderView);
                            }
                        }
                        Log.e("IMG", object);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),
                                "Load Image Failed", Toast.LENGTH_LONG).show();
                    }
                }
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

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
