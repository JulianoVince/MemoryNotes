package com.br.julianovincedecampos.core.usecase

import com.br.julianovincedecampos.core.repository.NoteRepository

class GetNota(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(id: Long) = noteRepository.getNote(id)

}