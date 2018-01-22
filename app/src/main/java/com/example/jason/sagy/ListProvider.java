package com.example.jason.sagy;

import android.content.Context;

import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.Collection;

public class ListProvider implements RemoteViewsService.RemoteViewsFactory  {
    private static final String TAG = "MyTag";

    private Context context;

    public ListProvider(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public int getCount() {
        return 0;
    }

//    @Override
//    public int getCount() {
//        Collection songs;
//        return songs.size();
//    }

    @Override
    public RemoteViews getViewAt(int position) {
        Log.d(TAG, "ListProvider.getViewAt(), position=" + position);

        RemoteViews ret = new RemoteViews(context.getPackageName(), R.layout.row_notification_list);
        return ret;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public void onDataSetChanged() {
    }
}