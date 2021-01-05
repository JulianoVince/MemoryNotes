package com.br.julianovincedecampos.core.usecase

import com.br.julianovincedecampos.core.data.Note
import com.br.julianovincedecampos.core.repository.NoteRepository

class RemoveNotes(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(note: Note) = noteRepository.remove(note)
    
}