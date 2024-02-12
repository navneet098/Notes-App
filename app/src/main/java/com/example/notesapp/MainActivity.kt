package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.activity.Note
import com.example.notesapp.adapter.NotesAdapter
import com.example.notesapp.data.NoteModel

class MainActivity : AppCompatActivity() {
    private val notes = mutableListOf<NoteModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rev_note)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = NotesAdapter(notes)
        recyclerView.adapter = adapter


        findViewById<ImageButton>(R.id.add).setOnClickListener {
            startActivityForResult(Intent(this, Note::class.java), ADD_NOTE_REQUEST)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            val title = data?.getStringExtra("title")
            val description = data?.getStringExtra("description")
            title?.let {
                val note = NoteModel(it, description ?: "")
                notes.add(note)
                adapter.notifyItemInserted(notes.size - 1)
            }
        }
    }

    companion object {
        const val ADD_NOTE_REQUEST = 1
    }
}
