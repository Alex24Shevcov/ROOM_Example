package com.smartherd.learnroom_itdev.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.smartherd.learnroom_itdev.REPOSITORY
import com.smartherd.learnroom_itdev.db.NoteDatabase
import com.smartherd.learnroom_itdev.db.repository.NoteRealization
import com.smartherd.learnroom_itdev.db.repository.NoteRepository
import com.smartherd.learnroom_itdev.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {
    val context = application

    fun initDatabase(){
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}