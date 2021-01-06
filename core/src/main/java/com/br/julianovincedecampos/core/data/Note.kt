package com.br.julianovincedecampos.core.data

import com.sun.tools.doclets.internal.toolkit.Content

data class Note(
    var title: String,
    var content: String,
    var creationTime: Long,
    var updateTine: Long,
    var id: Long = 0
)