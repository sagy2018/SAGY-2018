package com.example.jason.sagy;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationDisplayedResult;
import com.onesignal.OSNotificationReceivedResult;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by goa on 22/1/18.
 */

public class NotificationService extends NotificationExtenderService
{

    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult notification) {
        OverrideSettings overrideSettings = new OverrideSettings();
        overrideSettings.androidNotificationId = 88888;
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
//                Model model = new Model(title, content);
                NotificationCompat.Builder build  =  sendNotification(title,getApplicationContext(),builder);
                return  build;
            }
        };

        OSNotificationDisplayedResult displayedResult = displayNotification(overrideSettings);
        Log.d("OneSignalExample", "Notification displayed with id: " + displayedResult.androidNotificationId);

        return true;
    }

    static ArrayList<String> notifications =  new ArrayList<>();
    private NotificationCompat.Builder sendNotification(String messageBody, Context context, NotificationCompat.Builder builder) {
        startApplication().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,startApplication(),PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("TITLE")
                .setSummaryText("You have "+ notifications.size()+1 +" notifications");
        notifications.add(messageBody);

        for(int i=0;i< notifications.size();i++){
            inboxStyle.addLine(notifications.get(i));
        }
        Uri defaultUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Title")
                .setContentText(messageBody)
                .setSound(defaultUri).setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setStyle(inboxStyle);
        return  builder;
    }

    public static Intent startApplication(){
        Intent launchIntent = new Intent();
        launchIntent.setComponent(new ComponentName(" com.example.jason.sagy;\n","com.example.jason.sagy.Notifications"));
        return  launchIntent;
    }
}
