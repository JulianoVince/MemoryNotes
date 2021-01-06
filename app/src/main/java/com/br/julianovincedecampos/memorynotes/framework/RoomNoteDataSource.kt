package com.br.julianovincedecampos.memorynotes.framework

import android.content.Context
import com.br.julianovincedecampos.core.data.Note
import com.br.julianovincedecampos.core.repository.NoteDataSource
import com.br.julianovincedecampos.memorynotes.framework.db.DatabaseService
import com.br.julianovincedecampos.memorynotes.framework.db.NoteEntity

class RoomNoteDataSource(context: Context) : NoteDataSource {

    val noteDao = DatabaseService.invoke(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll() = noteDao.getAllNoteEntities().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))

}