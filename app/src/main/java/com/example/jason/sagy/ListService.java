package com.example.jason.sagy;

import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViewsService;

/**
 * Created by goa on 22/1/18.
 */

public class ListService extends RemoteViewsService {
    private static final String TAG = "MyTag";

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        Log.d(TAG, "onGetViewFactory()");
        return new ListProvider(getApplicationContext());
    }
}