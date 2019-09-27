package com.biomanuel97.notekeeper;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {
    private NoteRecyclerAdapter mNoteRecyclerAdapter;

//    private ArrayAdapter<NoteInfo> mAdapterNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoteListActivity.this, NoteActivity.class));
            }
        });

        initializeDisplayContent();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mAdapterNotes.notifyDataSetChanged();
        mNoteRecyclerAdapter.notifyDataSetChanged();
    }

    private void initializeDisplayContent() {
//        final ListView listNotes = (ListView) findViewById(R.id.list_notes);
//
//        List<NoteInfo> notes = DataManager.getInstance().getNotes();
//        mAdapterNotes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
//
//        listNotes.setAdapter(mAdapterNotes);
//
//        listNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(NoteListActivity.this, NoteActivity.class);
////                NoteInfo note = (NoteInfo) listNotes.getItemAtPosition(position);
//                intent.putExtra(NoteActivity.NOTE_ID, position);
//                startActivity(intent);
//            }
//        });
        RecyclerView recyclerNotes = (RecyclerView) findViewById(R.id.list_notes);
        LinearLayoutManager noteLayoutManager = new LinearLayoutManager(this);
        recyclerNotes.setLayoutManager(noteLayoutManager);

        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        mNoteRecyclerAdapter = new NoteRecyclerAdapter(NoteListActivity.this, null);
        recyclerNotes.setAdapter(mNoteRecyclerAdapter);
    }

}
