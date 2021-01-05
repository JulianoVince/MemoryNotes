package com.br.julianovincedecampos.core.repository

import com.br.julianovincedecampos.core.data.Note

interface NoteDataSource {

    suspend fun add(note: Note)

    suspend fun get(id: Long): Note?

    suspend fun getAll(): List<Note>

    suspend fun remove(note: Note)
    
}