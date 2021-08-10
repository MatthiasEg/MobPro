package ch.hslu.mobpro.comandcon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpDemosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.httpdemo);
    }


    public void loadBinaryData(View view) {
        LoadBinaryDataTask task = new LoadBinaryDataTask((ImageView)findViewById(R.id.imageView));
        try {
            task.execute(new URL("http://wherever.ch/hslu/homer.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    public void loadTextData(View view) {

    }

    public void jsonWebServiceButtonClicked(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.nactem.ac.uk/software/acromine/")
                .build();

        AcronymService service = retrofit.create(AcronymService.class);

        try {
            Response<List<AcronymDef>> response = service.getDefinitionsOf("http").execute();
            if(response.isSuccessful()){
                System.out.println(response.body());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
