package com.example.apiheroes.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiheroes.databinding.ItemrecyequipoBinding
import com.example.apiheroes.databinding.ItemrecypoderesBinding
import com.example.apiheroes.modelos.Equipo
import com.example.apiheroes.modelos.Poderes

class AdapterPoderes (val poderes : MutableList<Poderes>?): RecyclerView.Adapter<AdapterPoderes.ViewHolder>(){

    inner class ViewHolder(var binding: ItemrecypoderesBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemrecypoderesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var power=poderes!![position]
        var binding = holder.binding
        power.apply {
            binding.apply {
                textID.text = "ID : $id"
                textName.text = "Poderes : $poder"
            }
        }
    }

    override fun getItemCount(): Int {
        return poderes!!.size
    }

}