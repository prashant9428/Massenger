package com.drewdoor.massenger;

import android.app.Notification;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.drewdoor.massenger.App.CHANNEL_ID_1;


public class MainActivity extends AppCompatActivity {

    public static final String PREF_NAME = "Preference";
    public static final String STRING_KEY = "saveText";


    private TextView showHere;
    private EditText inputText;
    private String text ;

    private NotificationManagerCompat mNotificationManagerCompat;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mNotificationManagerCompat = NotificationManagerCompat.from(this);

            showHere = (TextView) findViewById(R.id.textHere);
            inputText = (EditText) findViewById(R.id.insertText);


        }

    public void submitTypo(View view) {

        SharedPreferences preferences = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(STRING_KEY,inputText.getText().toString());
        editor.apply();

    }
    public void saveTypo(View view) {

            SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
            text = sharedPreferences.getString(STRING_KEY,"");
    }

    public void sendNotification(View view) {

            Bitmap largeImage = BitmapFactory.decodeResource(getResources(),R.drawable.dog);

        Notification channel = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_music)
                .setContentTitle("Let me love you - DJ snake")
                .setContentText("Song by justin beaber")
                .setLargeIcon(largeImage)
                .addAction(R.drawable.ic_like,"like",null)
                .addAction(R.drawable.ic_prev,"prev",null)
                .addAction(R.drawable.ic_pause,"pause",null)
                .addAction(R.drawable.ic_next,"next",null)
                .addAction(R.drawable.ic_dislike,"dislike",null)
                .setStyle(new android.support.v4.media.app.NotificationCompat.MediaStyle().
                        setShowActionsInCompactView(1,2,3))
                .build();
                mNotificationManagerCompat.notify(1,channel);

    }



}
