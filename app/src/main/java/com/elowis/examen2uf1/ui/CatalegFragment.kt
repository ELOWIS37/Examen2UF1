package com.elowis.examen2uf1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.elowis.examen2uf1.adapter.CatalogAdapter
import com.elowis.examen2uf1.viewmodel.CatalegViewModel
import com.elowis.repas.R
import com.elowis.repas.databinding.FragmentCatalegBinding

class CatalegFragment : Fragment() {
    private lateinit var binding: FragmentCatalegBinding
    private lateinit var viewModel: CatalegViewModel
    private lateinit var adapter: CatalogAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalegBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this).get(CatalegViewModel::class.java)
        binding.viewModel = viewModel
        binding.cataleg.layoutManager = LinearLayoutManager(context)

        adapter = CatalogAdapter()
        binding.cataleg.adapter = adapter

        viewModel.obtenirCataleg(requireContext())?.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })


        return binding.root
    }
}
