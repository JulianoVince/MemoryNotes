package com.br.julianovincedecampos.memorynotes.framework.di

import com.br.julianovincedecampos.core.repository.NoteRepository
import com.br.julianovincedecampos.core.usecase.AddNotes
import com.br.julianovincedecampos.core.usecase.GetAllNotes
import com.br.julianovincedecampos.core.usecase.GetNota
import com.br.julianovincedecampos.core.usecase.RemoveNotes
import com.br.julianovincedecampos.memorynotes.framework.db.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
        addNotes = AddNotes(repository),
        getNota = GetNota(repository),
        getAllNotes = GetAllNotes(repository),
        removeNotes = RemoveNotes(repository)
    )

}