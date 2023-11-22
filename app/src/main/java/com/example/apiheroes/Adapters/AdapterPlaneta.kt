package com.example.apiheroes.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiheroes.databinding.ItemrecyplanetaBinding
import com.example.apiheroes.modelos.Planeta

class AdapterPlaneta (val planeta : List<Planeta>?): RecyclerView.Adapter<AdapterPlaneta.ViewHolder>(){

    inner class ViewHolder(var binding: ItemrecyplanetaBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemrecyplanetaBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var planet=planeta!![position]
        var binding = holder.binding
        planet.apply {
            binding.apply {
                textID.text = "ID : $id"
                textName.text = "Planeta : $nombrePlaneta"
            }
        }
    }

    override fun getItemCount(): Int {
        return planeta!!.size
    }

}