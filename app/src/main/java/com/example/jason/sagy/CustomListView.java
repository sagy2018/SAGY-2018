package com.example.jason.sagy;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class CustomListView extends ArrayAdapter<String> {
    private String[] MPName;
    private String[] desc;
    private Integer[] imgid;

    private Activity context;


    public CustomListView(Activity context, String[] MPName, String[] desc, Integer[] imgid) {
        super(context, R.layout.layout, MPName);
        this.context = context;
        this.MPName = MPName;
        this.desc = desc;
        this.imgid = imgid;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r = convertView;
        ViewHolder viewHolder = null;
        if (r == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.layout, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) r.getTag();
        }

        Picasso.with(context)
                .load(imgid[position])
                .fit()
                .into(viewHolder.ivw);

//        viewHolder.ivw.setImageResource(imgid[position]);
        viewHolder.tvw1.setText(MPName[position]);
        viewHolder.tvw2.setText(desc[position]);


        return r;
    }

    class ViewHolder {
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;

        ViewHolder(View v) {
            tvw1 = (TextView) v.findViewById(R.id.textView5);
            tvw2 = (TextView) v.findViewById(R.id.textView4);
            ivw = (ImageView) v.findViewById(R.id.imageView);
        }
    }
}
