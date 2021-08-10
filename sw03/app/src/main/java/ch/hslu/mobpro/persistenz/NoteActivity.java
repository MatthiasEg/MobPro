package ch.hslu.mobpro.persistenz;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NotesDatabase db = Room.databaseBuilder(getApplicationContext(), NotesDatabase.class, "notes-db").build();

        Intent intent = getIntent();
        long whichViewToDisplay = intent.getLongExtra("whichNoteView", 1);

        if (whichViewToDisplay < 0) {
            setContentView(R.layout.activity_edit_note);

            ((EditText) findViewById(R.id.note_text)).getText();

        } else {
            setContentView(R.layout.activity_show_note);
        }



    }
}
