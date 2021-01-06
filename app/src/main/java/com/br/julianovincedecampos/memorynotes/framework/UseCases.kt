package com.br.julianovincedecampos.memorynotes.framework

import com.br.julianovincedecampos.core.usecase.AddNotes
import com.br.julianovincedecampos.core.usecase.GetAllNotes
import com.br.julianovincedecampos.core.usecase.GetNota
import com.br.julianovincedecampos.core.usecase.RemoveNotes

data class UseCases(
    val addNotes: AddNotes,
    val getAllNotes: GetAllNotes,
    val getNota: GetNota,
    val removeNotes: RemoveNotes
)
