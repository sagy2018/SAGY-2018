package com.example.jason.sagy;

import android.app.Notification;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RemoteViews;

import com.onesignal.OneSignal;

public class Notifications extends AppCompatActivity {

    private ListView notificationListView;
    private MyCursorAdapter cursorAdapter;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        notificationListView = findViewById(R.id.notification_listView);


        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        DbHelper dbHelper = new DbHelper(Notifications.this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                ContractClass.Utils.ID,
                ContractClass.Utils.COLUMN_TITLE,
                ContractClass.Utils.COLUMN_CONTENT
        };

        String order = ContractClass.Utils.ID + " DESC";

        cursor = db.query(
                ContractClass.Utils.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                order
        );

        new Handler().post(new Runnable() {
            @Override
            public void run() {

                cursorAdapter = new MyCursorAdapter(Notifications.this, cursor);
                notificationListView.setAdapter(cursorAdapter);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (cursorAdapter != null) {
            cursorAdapter.notifyDataSetChanged();
        }
    }
}
