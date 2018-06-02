package zzr.licenta.gymapp.Alarm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import zzr.licenta.gymapp.ActivityClasses.MainActivity;
import zzr.licenta.gymapp.R;

/**
 * Created by Andrei on 29-May-18.
 */

public class MyAlarm extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_NOTIFICATION_URI);
        mediaPlayer.start();


        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_UNSPECIFIED);

            // Configure the notification channel.

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE hh:mm");

        Intent intent1 = new Intent(context,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent1, 0);

        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_menu_plans)
                .setContentIntent(pendingIntent)
                .setContentTitle("GymApp Reminder")
                .setContentText("It's "
                        + sdf.format(Calendar.getInstance().getTime())
                        + " and you need your workout!")
                .setContentInfo("Info");

        notificationManager.notify(1, notificationBuilder.build());


    }
}
