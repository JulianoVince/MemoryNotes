package com.br.julianovincedecampos.memorynotes.framework.db

import com.br.julianovincedecampos.core.usecase.*

data class UseCases(
    val addNotes: AddNotes,
    val getAllNotes: GetAllNotes,
    val getNota: GetNota,
    val removeNotes: RemoveNotes,
    val getWordCount: GetWordCount
)
