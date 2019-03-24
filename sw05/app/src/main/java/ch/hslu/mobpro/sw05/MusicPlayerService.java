package ch.hslu.mobpro.sw05;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public final class MusicPlayerService extends Service{

    private Thread playThread = new Thread();
    private static final int NOTIFICATION_ID = 123;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startPlayer();
        return super.onStartCommand(intent, flags, startId);
    }

    private void startPlayer() {
        if (playThread != null && playThread.isAlive()){
            return ;
        }
        startPlayThread();
        startForeground(NOTIFICATION_ID, createNotification("Playing.."));
    }

    private Notification createNotification(String s) {

        return null;
    }

    private void startPlayThread() {
        playThread.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
