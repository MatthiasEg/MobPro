package ch.hslu.mobpro.sw05;

import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public final static String CHANNEL_ID = "Notification ID SW05";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPlayerService(View view) {
        startService(new Intent(this, MusicPlayerService.class));
    }

    public void stopPlayerService(View view) {
        stopService(new Intent(this, MusicPlayerService.class));
    }
}
