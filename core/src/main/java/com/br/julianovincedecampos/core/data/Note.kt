package com.br.julianovincedecampos.core.data

import javax.naming.Context

data class Note(
    var title: String,
    var context: Context,
    var creationTime: String,
    var updateTine: Long,
    var id: Long = 0
)