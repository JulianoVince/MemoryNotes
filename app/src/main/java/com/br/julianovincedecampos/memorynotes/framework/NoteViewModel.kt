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
import com.br.julianovincedecampos.memorynotes.framework.di.ApplicationModule
import com.br.julianovincedecampos.memorynotes.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCase: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule((getApplication())))
            .build()
            .inject(this)
    }

    val saved = MutableLiveData<Boolean>()
    val currentNote = MutableLiveData<Note?>()

    fun saveNote(note: Note) {
        coroutineScope.launch {
            useCase.addNotes(note = note)
        }
    }

    fun getNote(id: Long) {
        coroutineScope.launch {
            val note = useCase.getNota(id)
            currentNote.postValue(note)
        }
    }

    fun deleteNote(note: Note) {
        coroutineScope.launch {
            useCase.removeNotes(note)
            saved.postValue(true)
        }
    }
}