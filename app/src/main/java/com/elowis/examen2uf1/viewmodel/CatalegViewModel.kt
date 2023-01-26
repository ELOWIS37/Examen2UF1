package com.elowis.examen2uf1.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import com.elowis.examen2uf1.model.Cataleg
import com.elowis.examen2uf1.repositori.Repositori

class CatalegViewModel {
    var cataleg: LiveData<List<Cataleg>>? = null

    //INSERT cataleg
    fun newCataleg(context: Context, nom: String, preu: Int) {
        var catalegVM=Cataleg(nom,preu)
        Repositori.insertCataleg(context,catalegVM)
    }

    //SQL cataleg
    fun obtenirCataleg(context: Context) : LiveData<List<Cataleg>>? {
        cataleg = Repositori.getCataleg(context)
        return cataleg
    }


}