package ch.hslu.mobpro.persistenz;

import android.app.ListActivity;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.List;

public class NoteListActivity extends ListActivity {

    private NotesDatabase db = Room.databaseBuilder(getApplicationContext(), NotesDatabase.class, "notes-db").build();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final List<Note> notes = db.noteDao().getAllNotes();
        final NotesAdapter adapter = new NotesAdapter(this, notes);
        setListAdapter(adapter);

    }
}
