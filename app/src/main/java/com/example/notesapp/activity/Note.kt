package com.example.notesapp.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.notesapp.R
import com.example.notesapp.data.NoteModel
import com.google.android.material.textfield.TextInputEditText

class Note : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        val saveButton: ImageButton = findViewById(R.id.button_save)
        val titleEditText: TextInputEditText = findViewById(R.id.title)
        val descriptionEditText: TextInputEditText = findViewById(R.id.description)

        saveButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("title", title)
            resultIntent.putExtra("description", description)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
