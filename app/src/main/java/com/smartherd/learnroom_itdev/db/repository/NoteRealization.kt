package com.smartherd.learnroom_itdev.db.repository

import androidx.lifecycle.LiveData
import com.smartherd.learnroom_itdev.db.dao.NoteDao
import com.smartherd.learnroom_itdev.model.NoteModel


// В этом классе уже мы объединяем интерфейсы NoteRepository и NoteDao
class NoteRealization(private val noteDao: NoteDao): NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }

}