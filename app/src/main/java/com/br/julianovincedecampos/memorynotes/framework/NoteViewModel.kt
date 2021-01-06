package com.br.julianovincedecampos.memorynotes.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.br.julianovincedecampos.core.data.Note
import com.br.julianovincedecampos.core.repository.NoteRepository
import com.br.julianovincedecampos.core.usecase.AddNotes
import com.br.julianovincedecampos.core.usecase.GetAllNotes
import com.br.julianovincedecampos.core.usecase.GetNota
import com.br.julianovincedecampos.core.usecase.RemoveNotes
import com.br.julianovincedecampos.memorynotes.framework.db.UseCases
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val repository = NoteRepository(RoomNoteDataSource(application))

    val useCase = UseCases(
        AddNotes(repository),
        GetAllNotes(repository),
        GetNota(repository),
        RemoveNotes(repository)
    )

    val saved = MutableLiveData<Boolean>()

    fun saveNote(note: Note) {
        coroutineScope.launch {
            useCase.addNotes(note = note)
        }
    }
}