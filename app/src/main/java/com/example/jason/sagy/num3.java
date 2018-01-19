package com.example.jason.sagy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class num3 extends AppCompatActivity {
    TextView t12;
    Button click;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num3);
        t12=(TextView) findViewById(R.id.tele3);
        click=(Button) findViewById(R.id.butte3);
        close=(Button) findViewById(R.id.bute3);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t12.setText(
                                " Name                                 : Shri Paul Manoj Pandian\n" +
                                "Adopted village                   : Thovalai gram panchayat in thovalai sub taluk\n" +
                                "District                                  : Kanyakumari\n" +
                                "Elected from                        :tamilnadu\n" +
                                "Party name                          :All India Anna Dravidian Munnetra Kalagam\n" +
                                "Educational qualifications: B. L educated at dr. Ambedkar law college, Chennai and\n" +
                                "                                                M.L. at Madras university, Chennai;\n" +
                                "Date of birth                        :August 8,1971\n" +
                                "Member of                          : Rajya Sabha\n" +
                                "Positions held                     : 2001-2006 member, tamilnadu legislative assembly\n2001-2002-member, rules committee,\n" +
                                                                      "Tamilnadu legislative assembly 2001-2004 senate member,\n" +
                                                                      "Dr. Ambedkar law university member,\n" +
                                                                      "Ex-servicemen’s welfare board 2004-2006 chairman,\n" +
                                                                      "Estimates committee,\n" +
                                                                      "Elected to Rajya Sabha sep 2010 onwards,\n" +
                                                                       "Committee on science and technology,\n" +
                                                                       "Environments and forest member,\n" +
                                                                       "Committee on petitions member,\n" +
                                                                      "Consultative committee for the ministry of civil aviation’s;");
            }
        });
    }
}
