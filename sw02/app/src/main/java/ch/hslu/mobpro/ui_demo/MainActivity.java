package ch.hslu.mobpro.ui_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void startLinearLayout(View view){
        Intent intent = new Intent(this, LayoutDemoActivity.class);
        intent.putExtra("layout", "linear");
        startActivity(intent);
    }

    public void startRelativeLayout(View view){
        Intent intent = new Intent(this, LayoutDemoActivity.class);
        intent.putExtra("layout", "relative");
        startActivity(intent);
    }

    public void startViewsDemoActivity(View view){
        Intent intent = new Intent(this, ViewsDemoActivity.class);
        startActivity(intent);
    }




}
