package com.br.julianovincedecampos.memorynotes.framework.di

import com.br.julianovincedecampos.memorynotes.framework.ListViewModel
import com.br.julianovincedecampos.memorynotes.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}