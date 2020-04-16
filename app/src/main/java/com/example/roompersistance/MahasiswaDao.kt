package com.example.roompersistance

import androidx.room.*

@Dao
interface MahasiswaDao{
    @Query("Select * from mahasiswa")
    fun getAll(): List<MahasiswaEntity>

    @Query("SELECT * FROM mahasiswa WHERE nama like :nama")
    fun findByName(nama: String): MahasiswaEntity

    @Insert
    fun insertAll(vararg mData: MahasiswaEntity)

    @Delete
    fun deleteData(mhs: MahasiswaEntity)

    @Update
    fun updateData(vararg  mData: MahasiswaEntity)
}