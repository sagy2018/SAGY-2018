package com.example.jason.sagy;

/**
 * Created by goa on 23/1/18.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lincoln on 31/03/16.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {

    private List<Image> images;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView thumbnail;
        private TextView title;
        private List<Image>imageList;
        private Context context;


        public MyViewHolder(Context context, View view, List<Image>imageList) {
            super(view);
            this.imageList = imageList;
            this.context = context;

            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            title = (TextView)view.findViewById(R.id.title) ;

            thumbnail.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int posiion = getAdapterPosition();
            Image image = imageList.get(posiion);
            String url = image.getUrlOfImage();
            Intent i = new Intent(context, ImageOpenActivity.class);
            i.putExtra("URL", url);
            context.startActivity(i);
        }
    }


    public GalleryAdapter(Context context, List<Image> images) {
        mContext = context;
        this.images = images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_thumbnail, parent, false);

        return new MyViewHolder(mContext, itemView, images);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Image image = images.get(position);

        Image name  = images.get(position);

        String title = name.getName();
        holder.title.setText(title);
        Picasso.with(mContext)
                .load(image.getUrlOfImage())
                .fit()
                .into(holder.thumbnail);

//        Glide.with(mContext).load(image.getMedium())
//                .crossFade()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

}