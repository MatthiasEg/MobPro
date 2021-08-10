package ch.hslu.mobpro.persistenz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NotesAdapter extends ArrayAdapter<Note> {


    public NotesAdapter(Context context, List<Note> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Note note = getItem(position);
        if(view == null){
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_layout, parent);
        }

        ((TextView)(view.findViewById(R.id.note_title))).setText(note.noteTitle);
        ((TextView)(view.findViewById(R.id.note_text))).setText(note.noteText);

        return view;
    }
}
