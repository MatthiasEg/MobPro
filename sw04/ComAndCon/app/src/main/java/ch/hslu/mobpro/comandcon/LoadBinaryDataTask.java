package ch.hslu.mobpro.comandcon;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class LoadBinaryDataTask extends AsyncTask<URL, Void, Bitmap> {


    private WeakReference<ImageView> imageViewWeakReference;

    public LoadBinaryDataTask(ImageView imageView) {
        this.imageViewWeakReference = new WeakReference<>(imageView);
    }


    @Override
    protected Bitmap doInBackground(URL... urls) {

        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logger).build();

        Request request = new Request.Builder().url(urls[0]).build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return BitmapFactory.decodeStream(response.body().byteStream());
            } else {
                Log.d("http response", response.toString());
            }
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;


    }


    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (this.imageViewWeakReference != null){
            ImageView imageView = imageViewWeakReference.get();
            imageView.setImageBitmap(bitmap);
        }
    }
}
