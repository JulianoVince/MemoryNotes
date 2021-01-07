package com.br.julianovincedecampos.memorynotes.framework.di

import android.app.Application
import com.br.julianovincedecampos.core.repository.NoteRepository
import com.br.julianovincedecampos.memorynotes.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))

}