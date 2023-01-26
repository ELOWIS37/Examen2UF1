package com.elowis.examen2uf1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cataleg")
data  class Cataleg (

    @ColumnInfo(name = "nom")
    val nom: String,
    @ColumnInfo(name = "preu")
    val preu: Int

    ) {
    @PrimaryKey(autoGenerate = true)
    var Id:Int? = null
}