package ch.hslu.mobpro.persistenz;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NotesDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
