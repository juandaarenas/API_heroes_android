package com.example.apiheroes.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiheroes.API.rutaAPI
import com.example.apiheroes.databinding.ItemrecyheroeBinding
import com.example.apiheroes.databinding.ItemrecypoderesBinding
import com.example.apiheroes.modelos.Heroes
import com.example.apiheroes.modelos.Planeta
import com.example.apiheroes.modelos.Poderes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdapterHeroes (val heroes : MutableList<Heroes>?): RecyclerView.Adapter<AdapterHeroes.ViewHolder>(){

    inner class ViewHolder(var binding: ItemrecyheroeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemrecyheroeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var hero=heroes!![position]
        var binding = holder.binding
        hero.apply {
            binding.apply {
                textID.text = "ID : $id"
                textName.text = "Nombre : $nombreHeroe"
                textAge.text ="Edad : $edad"
                rutaAPI.builderPlaneta.getById(planetas_id.toInt()).enqueue(object: Callback<MutableList<Planeta>?> {
                    override fun onResponse(call: Call<MutableList<Planeta>?>?, response: Response<MutableList<Planeta>?>?){
                        var planet=response?.body()?.toMutableList()
                        planet?.forEach {
                            textPlaneta.text="Planeta : ${it.nombrePlaneta}"
                        }
                    }
                    override fun onFailure(call: Call<MutableList<Planeta>?>?, t:Throwable) {
                        Toast.makeText(binding.root.context, "error", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }

    override fun getItemCount(): Int {
        return heroes!!.size
    }

}