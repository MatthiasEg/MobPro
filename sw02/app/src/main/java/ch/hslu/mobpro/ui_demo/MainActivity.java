package ch.hslu.mobpro.ui_demo;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        ((TextView)findViewById(R.id.zählerText)).setText("Zähler: " + this.viewModel.getCounter());

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String courses[] = getResources().getStringArray(R.array.ITCourses);
                Toast.makeText(getApplicationContext(),courses[position] + " ausgewählt!",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.viewModel.incrementCounter();
                ((TextView)findViewById(R.id.zählerText)).setText("Zähler: " + MainActivity.this.viewModel.getCounter() );
            }
        });



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
