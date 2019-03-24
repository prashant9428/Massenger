package com.drewdoor.massenger;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String  CHANNEL_ID_1 = "channel1";
    public static final String CHANNEL_NAME_1 = "FIRSTCHANNEL";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();

    }

    private void createNotificationChannel() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channle1 = new NotificationChannel(
                    CHANNEL_ID_1,
                    CHANNEL_NAME_1,
                    NotificationManager.IMPORTANCE_HIGH

            );
            channle1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            channle1.enableLights(true);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channle1);
        }


    }


}

