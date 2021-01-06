package com.br.julianovincedecampos.memorynotes.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(NoteEntity::class), version = 1)
abstract class DatabaseService : RoomDatabase() {

    companion object {
        @Volatile
        private var instance: DatabaseService? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DatabaseService::class.java,
            "note.db"
        ).build()
    }

    abstract fun noteDao(): NoteDao
}