package ch.hslu.mobpro.comandcon;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.drm.DrmStore;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Thread(new Runnable() {
            @Override
            public void run() {

                String url = "http://www.nactem.ac.uk/software/acromine/dictionary.py?sf=HTTP";
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder().url(url).build();

                try {
                    Response response = client.newCall(request).execute();
                    String json = response.body().string();
                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<AcronymDef>>(){}.getType();
                    final List<AcronymDef> definitions = gson.fromJson(json, listType);

                    gson.to

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, definitions.toString(), Toast.LENGTH_LONG).show();
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        }).start();





    }


}