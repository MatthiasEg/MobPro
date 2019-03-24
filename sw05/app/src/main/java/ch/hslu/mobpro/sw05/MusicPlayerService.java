package ch.hslu.mobpro.sw05;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public final class MusicPlayerService extends Service{

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
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
