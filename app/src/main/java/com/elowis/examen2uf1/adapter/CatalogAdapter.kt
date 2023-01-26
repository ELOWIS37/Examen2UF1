package com.elowis.examen2uf1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.elowis.examen2uf1.model.Cataleg
import com.elowis.examen2uf1.viewmodel.CatalegViewModel
import com.elowis.repas.R
import com.elowis.repas.databinding.FragmentCatalegBinding

class CatalogAdapter(val context: Context, val cataleg: Cataleg) :
    ListAdapter<Cataleg, CatalogAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<FragmentCatalegBinding>(
            LayoutInflater.from(parent.context),
            R.layout.cardview, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cataleg = getItem(position)
        holder.bind(cataleg)
    }

    inner class ViewHolder(val binding: FragmentCatalegBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cataleg: Cataleg) {
            binding.cataleg = cataleg
            binding.executePendingBindings()
            binding.viewModel = viewModel
        }
    }
    class DiffCallback : DiffUtil.ItemCallback<Cataleg>() {
        override fun areItemsTheSame(oldItem: Cataleg, newItem: Cataleg): Boolean {
            return oldItem.nom == newItem.nom
        }

        override fun areContentsTheSame(oldItem: Cataleg, newItem: Cataleg): Boolean {
            return oldItem == newItem
        }
    }
    }

