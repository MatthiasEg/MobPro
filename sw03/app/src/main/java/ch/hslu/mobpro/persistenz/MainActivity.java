package ch.hslu.mobpro.persistenz;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class MainActivity extends AppCompatActivity {

    private static final String COUNTER_KEY = "counterKey";
    private final static int REQUEST_CODE_TEE_PREF = 1234;
    private static final String FILE_NAME = "notes.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onResume() {
        super.onResume();

        final SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        final int newResumeCount = preferences.getInt(COUNTER_KEY, 0) + 1;
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(COUNTER_KEY, newResumeCount);
        editor.apply();

        TextView textView = (TextView) findViewById(R.id.textViewOnResumeCount);
        textView.setText("MainActivity.onResume() wurde seit der Installation diese App " + newResumeCount + " mal aufgerufen.");


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        TextView teeTextView = (TextView) findViewById(R.id.textView4);
        String teaSweetener = sharedPreferences.getString("teaSweetener", "");
        String preferredTee = sharedPreferences.getString("teaPreferred", "");
        teeTextView.setText("Ich trinke am liebsten " + preferredTee + ", mit " + getTeaSweetener(teaSweetener) + " gesüsst.");


    }

    private String getTeaSweetener(String teaSweetenerValue) {
        switch (teaSweetenerValue) {
            case "artificial":
                return "Süssstoff";
            case "refined":
                return "Assugrin";
            case "natural":
                return "Rohrzucker";
            default:
                return "";
        }

    }


    public void teePreferencesButtonPressed(View view) {
        Intent intent = new Intent(this, AppPreferenceActivity.class);
        startActivityForResult(intent, REQUEST_CODE_TEE_PREF);
    }


    public void defaultsButtonPressed(View view) {
        TextView teeTextView = (TextView) findViewById(R.id.textView4);
        teeTextView.setText("Ich trinke am liebsten Lipton/Pfefferminztee, mit Rohrzucker gesüsst.");

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("teaPreferred", "Lipton/Pfefferminztee");
        editor.putString("teaSweetener", "Rohrzucker");
        editor.commit();
    }

    public void safeData(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        File outFile;

        if (checkBox.isChecked()) {
            this.loadExtFilePermission();

            File root = Environment.getExternalStorageDirectory();
            File dir = new File(root.getAbsolutePath() + "/data");
            dir.mkdirs();
            outFile = new File(dir, FILE_NAME);


        } else {
            File root = this.getFilesDir();
            File dir = new File(root.getAbsolutePath() + "/data");
            dir.mkdirs();
            outFile = new File(dir, FILE_NAME);

        }

        Writer writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(outFile));
            EditText editText = (EditText) findViewById(R.id.editText);
            writer.append(editText.getText());

            writer.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } finally {
            TextView textView = (TextView) findViewById(R.id.statusReadWrite);
            textView.setText("Data saved!");

        }
    }

    public void loadData(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        File fileToRead;

        if (checkBox.isChecked()) {
            loadExtFilePermission();
            File root = Environment.getExternalStorageDirectory();
            fileToRead = new File(root.getAbsolutePath() + "/data/notes.txt");
        } else {
            File root = this.getFilesDir();
            fileToRead = new File(root.getAbsolutePath() + "/data/notes.txt");

        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
            EditText editText = (EditText) findViewById(R.id.editText);


            editText.setText(reader.readLine());
            TextView textView = (TextView) findViewById(R.id.statusReadWrite);
            textView.setText("Data read successfully");
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public boolean loadExtFilePermission() {
        int writeGrant = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (writeGrant != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 24);
        } else {
            return true;
        }
        return false;
    }
    

    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 24: //load file

                if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission" + permissions[0] + " denied!", Toast.LENGTH_SHORT).show();
                }
        }
    }


}
