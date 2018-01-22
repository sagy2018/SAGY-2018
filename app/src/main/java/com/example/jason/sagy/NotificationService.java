package com.example.jason.sagy;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationDisplayedResult;
import com.onesignal.OSNotificationReceivedResult;

import java.math.BigInteger;

/**
 * Created by goa on 22/1/18.
 */

public class NotificationService extends NotificationExtenderService
{

    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult notification) {
        OverrideSettings overrideSettings = new OverrideSettings();
        overrideSettings.extender = new NotificationCompat.Extender() {
            @Override
            public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
                // Sets the background notification color to Green on Android 5.0+ devices.
                Log.i("Noti title", "extend: "+builder.mContentTitle+"\n"+builder.mContentText+"\n"+builder.mNotification+"");

                DbHelper dbHelper = new DbHelper(NotificationService.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                String title = builder.mContentTitle.toString();
                String content =  builder.mContentText.toString();

                dbHelper.insertData(title, content, db);
                Model model = new Model(title, content);


                return builder.setColor(new BigInteger("FF00FF00", 16).intValue());
            }
        };

        OSNotificationDisplayedResult displayedResult = displayNotification(overrideSettings);
        Log.d("OneSignalExample", "Notification displayed with id: " + displayedResult.androidNotificationId);

        return true;
    }
}
