package com.elowis.examen2uf1.repositori

import android.content.Context
import androidx.lifecycle.LiveData
import com.elowis.examen2uf1.database.CatalegDatabase
import com.elowis.examen2uf1.model.Cataleg
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repositori {

    companion object {

        var catalegDatabase: CatalegDatabase? = null

        var cataleg: LiveData<List<Cataleg>>? = null

        fun initializeDB(context: Context) : CatalegDatabase {
            return CatalegDatabase.getDatabase(context)
        }

        //INSERT cataleg
        fun insertCataleg(context: Context, cataleg: Cataleg) {

            catalegDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                catalegDatabase!!.catalegDao().addCataleg(cataleg)
            }

        }

        //TODO: SQL cataleg
        fun getCataleg(context: Context) : LiveData<List<Cataleg>>? {

            catalegDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                cataleg = catalegDatabase!!.catalegDao().getCataleg()
            }

            return cataleg
        }

    }
}