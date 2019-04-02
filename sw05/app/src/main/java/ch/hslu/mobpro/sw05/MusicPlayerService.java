package ch.hslu.mobpro.sw05;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public final class MusicPlayerService extends Service {

    private Thread playThread;
    private static final int NOTIFICATION_ID = 123;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startPlayer();
        return Service.START_NOT_STICKY;
    }

    private void startPlayer() {
        if (playThread != null && playThread.isAlive()) {
            return;
        }
        startPlayThread();
        startForeground(NOTIFICATION_ID, createNotification("Playing.."));
    }

    private Notification createNotification(String s) {

        return new NotificationCompat.Builder(this, MainActivity.CHANNEL_ID)
                .setContentTitle("HSLU Music Player")
                .setTicker("HSLU Music Player")
                .setContentText(s)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setOngoing(true)
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setWhen(System.currentTimeMillis())
                .build();
    }

    private void startPlayThread() {

        playThread = new Thread(new Runnable() {
            @Override
            public void run() {
                MediaPlayer player = (MediaPlayer) MediaPlayer.create(MusicPlayerService.this, R.raw.test);
                player.start();
            }
        });

        playThread.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        stopPlayThread();
        super.onDestroy();
    }

    private void stopPlayThread() {
        playThread.interrupt();
    }
}
