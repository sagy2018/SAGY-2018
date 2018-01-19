package com.example.jason.sagy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Village extends AppCompatActivity {
    ListView lv;

    String [] VillageName={ "Pothiramangalam - Village OverviewGram","Thirumangalakudi - Village OverviewGram","Keelapalur -  Village OverviewGram",
            "Kodanad - Village OverviewGram","5.Thandalam - Village OverviewGram","Orathi - Village OverViewGram","Siruvachur - Village OverviewGram"
    ,"Rasingapuram - Village OverviewGram","Pethanadarpatty - Village OverviewGram","Thiruvakkarai - Village OverviewGram","Thirumanavayal - Village OverviewGram"
    ,"Palaviduthi - Village OverviewGram","Melravanthavadi - Village OverviewGram","Palli - Village OverviewGram"};
    String []Desc={"This is Pudupatti","This is arakasanahalli ","This is Thovalai ","This is Karumanur ","This is Maravanamangalam ","This is Vadakkupudur ","This is Chinnakuppam","This is Basuvapuram",
            "This is Gendanahalli","This is SriVenketesapuram","This is Hale Dharmapuri","This is Konanginaikanahalli","This is Annamalaihalli",
            "This is Pallavadi"};
    Integer [] Image={R.drawable.village,R.drawable.village,R.drawable.village,R.drawable.village,R.drawable.village,R.drawable.village
            ,R.drawable.village,R.drawable.village,R.drawable.village,R.drawable.village,R.drawable.village,R.drawable.village,R.drawable.village,R.drawable.village};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village);
        lv=(ListView)findViewById(R.id.listview12);
        Custom_ListView2 custom_listView2=new Custom_ListView2(this,VillageName,Image);
        lv.setAdapter(custom_listView2);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent=new Intent(Village.this,another.class);
                    startActivity(intent);
                }
                if(i==1){
                    Intent intent=new Intent(Village.this,thesec.class);
                    startActivity(intent);
                }
                if (i==2){
                    Intent intent=new Intent(Village.this,thethird.class);
                    startActivity(intent);
                }
                if(i==3){
                    Intent intent=new Intent(Village.this,thefourth.class);
                    startActivity(intent);

                }
                if(i==4){
                    Intent intent=new Intent(Village.this,thefifth.class);
                    startActivity(intent);
                }
                if(i==5){
                    Intent intent=new Intent(Village.this,thefifth.class);
                    startActivity(intent);
                }
                if(i==6){
                    Intent intent=new Intent(Village.this,thesixth.class);
                    startActivity(intent);
                }
                if(i==7){
                    Intent intent=new Intent(Village.this,theseventh.class);
                    startActivity(intent);
                }
                if(i==8){
                    Intent intent=new Intent(Village.this,theeighth.class);
                    startActivity(intent);
                }
                if(i==9){
                    Intent intent=new Intent(Village.this,theninth.class);
                    startActivity(intent);
                }
                if(i==10){
                    Intent intent=new Intent(Village.this,thetenth.class);
                    startActivity(intent);
                }
                if(i==11){
                    Intent intent=new Intent(Village.this,theeleventh.class);
                    startActivity(intent);
                }
                if (i == 12) {
                    Intent intent=new Intent(Village.this,thetwelth.class);
                    startActivity(intent);
                }
                if(i==13){
                    Intent intent=new Intent(Village.this,thethirteenth.class);
                    startActivity(intent);

                }
                if(i==14){
                    Intent intent=new Intent(Village.this,thefourteenth.class);
                    startActivity(intent);

                }



            }
        });
    }
}
