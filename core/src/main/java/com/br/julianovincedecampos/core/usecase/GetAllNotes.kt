package com.br.julianovincedecampos.core.usecase

import com.br.julianovincedecampos.core.repository.NoteRepository

class GetAllNotes(private val noteRepository: NoteRepository) {

    suspend operator fun invoke() = noteRepository.getAllNotes()
    
}