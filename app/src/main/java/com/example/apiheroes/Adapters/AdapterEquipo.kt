package com.example.apiheroes.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiheroes.databinding.ItemrecyequipoBinding
import com.example.apiheroes.databinding.ItemrecyplanetaBinding
import com.example.apiheroes.modelos.Equipo
import com.example.apiheroes.modelos.Planeta

class AdapterEquipo(val equipo : MutableList<Equipo>?): RecyclerView.Adapter<AdapterEquipo.ViewHolder>(){

    inner class ViewHolder(var binding: ItemrecyequipoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemrecyequipoBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var team=equipo!![position]
        var binding = holder.binding
        team.apply {
            binding.apply {
                textID.text = "ID : $id"
                textName.text = "Equipo : $nombreEquipo"
            }
        }
    }

    override fun getItemCount(): Int {
        return equipo!!.size
    }

}