package com.elowis.examen2uf1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.elowis.examen2uf1.model.Cataleg
import com.elowis.examen2uf1.viewmodel.CatalegViewModel
import com.elowis.repas.R
import com.elowis.repas.databinding.FragmentInsertCatalegBinding


class InsertCatalegFragment : Fragment() {

    private lateinit var binding: FragmentInsertCatalegBinding
    private lateinit var motorViewModel: CatalegViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_insert_cataleg, container, false
        )

        motorViewModel = ViewModelProvider(this).get(CatalegViewModel::class.java)


        //Button Insert
        binding.buttonInsert.setOnClickListener{
            val nom = binding.editTextNom.text.toString()
            val preu = binding.editTextPreu.text.toString().toInt()

            motorViewModel.newCataleg(requireContext().applicationContext,nom,preu)


        }
        return binding.root
    }
}