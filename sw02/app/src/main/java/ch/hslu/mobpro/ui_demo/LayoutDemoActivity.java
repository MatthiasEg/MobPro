package ch.hslu.mobpro.ui_demo;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LayoutDemoActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();

        String layout = bundle.getString("layout");

        System.out.println(layout);

        if (layout.equals("linear")){
            setContentView(R.layout.layoutdemo_linearlayout);
        } else{
            setContentView(R.layout.layoutdemo_constraintlayout);
        }




    }



}
