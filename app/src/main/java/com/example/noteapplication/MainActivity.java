package com.example.noteapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String PRESS_NAME = "NotePrefs";
    private static final String KEY_NOTE_COUNT = "NoteCount";

    private LinearLayout noteContainer;
    private List<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteContainer = findViewById(R.id.noteContainer);
        Button btnSave = findViewById(R.id.btnSave);

        noteList = new ArrayList<>();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });

        loadNotesFromPreferences();
        displayNotes();
    }

    private void displayNotes() {
        for (Note note : noteList) {
            createNoteView(note);
        }
    }

    private void loadNotesFromPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PRESS_NAME, MODE_PRIVATE);
        int noteCount = sharedPreferences.getInt(KEY_NOTE_COUNT, 0);

        for (int i = 0; i < noteCount; i++) {
            String title = sharedPreferences.getString("note_title_" + i, "");
            String content = sharedPreferences.getString("note_content_" + i, "");

            Note note = new Note();
            note.setTitle(title);
            note.setContent(content);

            noteList.add(note);
        }
    }

    private void saveNote() {
        EditText titleEditText = findViewById(R.id.txtTitle);
        EditText contentEditText = findViewById(R.id.txtContent);

        String title = titleEditText.getText().toString();
        String content = contentEditText.getText().toString();

        if (!title.isEmpty() && !content.isEmpty()) {
            Note note = new Note();
            note.setTitle(title);
            note.setContent(content);

            noteList.add(note);

            saveNotesToPreferences();
            createNoteView(note);
            clearInputFields();
        }
    }

    private void clearInputFields() {
        EditText titleEditText = findViewById(R.id.txtTitle);
        EditText contentEditText = findViewById(R.id.txtContent);

        titleEditText.getText().clear();
        contentEditText.getText().clear();
    }

    private void createNoteView(final Note note) {
        View noteView = getLayoutInflater().inflate(R.layout.note_item, null);
        TextView txtTitleView = noteView.findViewById(R.id.txtTitleView);
        TextView txtContentView = noteView.findViewById(R.id.txtContentView);

        txtTitleView.setText(note.getTitle());
        txtContentView.setText(note.getContent());

        noteView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDeleteDialog(note);
                return true; // Return true to indicate the event is handled
            }
        });

        noteContainer.addView(noteView);
    }

    private void showDeleteDialog(final Note note) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete this note");
        builder.setMessage("Are you sure you want to delete this note?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteNoteAndRefresh(note);
                dialog.dismiss(); // Close the dialog
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Close the dialog
            }
        });

        builder.create().show(); // Create and show the dialog
    }

    private void deleteNoteAndRefresh(Note note) {
        noteList.remove(note);
        saveNotesToPreferences();
        refreshNoteView();
    }

    private void refreshNoteView() {
        noteContainer.removeAllViews();
        displayNotes();
    }

    private void saveNotesToPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PRESS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_NOTE_COUNT, noteList.size());

        for (int i = 0; i < noteList.size(); i++) {
            Note note = noteList.get(i);
            editor.putString("note_title_" + i, note.getTitle());
            editor.putString("note_content_" + i, note.getContent());
        }

        editor.apply();
    }
}
