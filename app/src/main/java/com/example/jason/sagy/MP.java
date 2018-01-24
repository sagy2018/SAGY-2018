package com.example.jason.sagy;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MP extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    ListView lst;
    String[] MPName = {"Smt.Sasikala Pushpa", "Shri K.R. Arjunan", "Shri Paul Manoj Pandian", "Dr.K.P. Ramalingam", "Captain E.M. Sudarsana Natchiappan",
            "Shri.S. Thangavelu", "Shri Navaneethakrishnan. A", "Shri Selvaraj.A. K", "Shri Rabi Bernard.A.W", "Smt. Kanimozhi Karunanidhi", "Shri Lakshmanan Ramamoorthy"
            , "Smt. Vijila Sathyanath", "Shri Rathinavel Thangavel", "Dr.Maitreyan.V",};
    String[] desc = {"Member of Rajya Sabha", "Member of Rajya Sabha", "Member of Rajya Sabha", "Member of Rajya Sabha", "Member of Rajya Sabha", "Member of Rajya Sabha"
            , "Member of Rajya Sabha", "Member of Rajya Sabha", "Member of Rajya Sabha", "Member of Rajya Sabha", "Member of Rajya Sabha", "Member of Rajya Sabha"
            , "Member of Rajya Sabha", "Member of Rajya Sabha"};
    Integer[] imgid = {R.drawable.mp1, R.drawable.mp2, R.drawable.mp3, R.drawable.mp4, R.drawable.mp5, R.drawable.mp6, R.drawable.mp7, R.drawable.mp8,
            R.drawable.mp9, R.drawable.mp10, R.drawable.mp11, R.drawable.mp12, R.drawable.mp13, R.drawable.mp14};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp);
        lst = (ListView) findViewById(R.id.listview);

        CustomListView custom_listView = new CustomListView(this, MPName, desc, imgid);


        lst.setAdapter(custom_listView);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(MP.this, num2.class);
                    startActivity(intent);

                }
                if (i == 1) {

                    Intent in = new Intent(MP.this, second.class);
                    startActivity(in);
                }
                if (i == 2) {
                    Intent intent = new Intent(MP.this, num3.class);
                    startActivity(intent);

                }
                if (i == 3) {
                    Intent intent = new Intent(MP.this, num4.class);
                    startActivity(intent);
                }
                if (i == 4) {
                    Intent intent = new Intent(MP.this, num5.class);
                    startActivity(intent);
                }
                if (i == 5) {
                    Intent intent = new Intent(MP.this, num6.class);
                    startActivity(intent);
                }
                if (i == 6) {
                    Intent intent = new Intent(MP.this, num7.class);
                    startActivity(intent);
                }
                if (i == 7) {
                    Intent intent = new Intent(MP.this, num8.class);
                    startActivity(intent);
                }
                if (i == 8) {
                    Intent intent = new Intent(MP.this, num9.class);
                    startActivity(intent);
                }
                if (i == 9) {
                    Intent intent = new Intent(MP.this, num10.class);
                    startActivity(intent);
                }
                if (i == 10) {
                    Intent intent = new Intent(MP.this, num11.class);
                    startActivity(intent);
                }
                if (i == 11) {
                    Intent intent = new Intent(MP.this, num12.class);
                    startActivity(intent);
                }
                if (i == 12) {
                    Intent intent = new Intent(MP.this, num12.class);
                    startActivity(intent);
                }
                if (i == 13) {
                    Intent intent = new Intent(MP.this, num13.class);
                    startActivity(intent);
                }
                if (i == 14) {
                    Intent intent = new Intent(MP.this, num14.class);
                    startActivity(intent);
                }
            }
        });
    }
}
