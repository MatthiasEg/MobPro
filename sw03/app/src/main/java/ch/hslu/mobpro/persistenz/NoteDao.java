package ch.hslu.mobpro.persistenz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM note")
    List<Note> getAllNotes();

    @Insert
    void insertNote(Note note);
}
