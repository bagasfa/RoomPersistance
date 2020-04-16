package com.example.roompersistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MahasiswaEntity::class), version = 1)
abstract class MahasiswaDatabase: RoomDatabase(){
    abstract fun mDao(): MahasiswaDao

    companion object{
        @Volatile private var instances: MahasiswaDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instances ?: synchronized(LOCK){
            instances ?: buildDatabase(context).also { instances = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            MahasiswaDatabase::class.java, "mahasiswa.db").build()
    }

}