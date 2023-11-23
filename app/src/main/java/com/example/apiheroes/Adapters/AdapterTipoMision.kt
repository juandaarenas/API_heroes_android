package com.example.apiheroes.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiheroes.databinding.ItemrecypoderesBinding
import com.example.apiheroes.databinding.ItemrecytipomisionBinding
import com.example.apiheroes.modelos.Poderes
import com.example.apiheroes.modelos.TipoMision

class AdapterTipoMision (val tipoMision : MutableList<TipoMision>?): RecyclerView.Adapter<AdapterTipoMision.ViewHolder>(){

    inner class ViewHolder(var binding: ItemrecytipomisionBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemrecytipomisionBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var tm=tipoMision!![position]
        var binding = holder.binding
        tm.apply {
            binding.apply {
                textID.text = "ID : $id"
                textName.text = "Tipo Mision : $nombreTmision"
            }
        }
    }

    override fun getItemCount(): Int {
        return tipoMision!!.size
    }

}