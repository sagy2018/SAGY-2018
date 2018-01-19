package com.example.jason.sagy;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jason on 1/2/2018.
 */

public class Custom_ListView2 extends ArrayAdapter<String> {
    private String [] VillageName;
    private Integer [] Image;
    private Activity context;
    public Custom_ListView2(Activity context, String[] VillageName,Integer[] Image) {
        super(context,R.layout.layout2,VillageName);
        this.context=context;
        this.VillageName=VillageName;
        this.Image=Image;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        Viewholdr viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layout2,null,true);
            viewHolder=new Viewholdr(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder=(Viewholdr) r.getTag();
        }
        viewHolder.iv.setImageResource(Image[position]);
        viewHolder.tv.setText(VillageName[position]);
        return r;
    }
    class Viewholdr{
        TextView tv;
        ImageView iv;
        Viewholdr(View v){
            tv=(TextView) v.findViewById(R.id.tvm);
            iv=(ImageView) v.findViewById(R.id.imageView12);

        }


    }
}
