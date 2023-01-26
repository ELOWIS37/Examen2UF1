package com.elowis.examen2uf1.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.elowis.examen2uf1.model.Cataleg

@Dao
interface CatalegDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCataleg(cataleg: Cataleg)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateCataleg(cataleg: Cataleg)

    @Delete
    fun deleteCataleg(cataleg: Cataleg)

    @Query("SELECT * FROM Cataleg ORDER BY preu DESC")
    fun getCataleg(): LiveData<List<Cataleg>>

}