package com.example.apiheroes.Adapters

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiheroes.API.rutaAPI
import com.example.apiheroes.databinding.ItemrecyplanetaBinding
import com.example.apiheroes.modelos.Planeta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdapterPlaneta (val planeta : MutableList<Planeta>?): RecyclerView.Adapter<AdapterPlaneta.ViewHolder>(){

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
                btnEliminar.setOnClickListener {
                    AlertDialog.Builder(binding.root.context)
                        .setMessage("¿Desea eliminar la raza $nombrePlaneta?")
                        .setPositiveButton("Ok") { view, b ->
                            rutaAPI.builderPlaneta.Delete(planet.id.toInt()).enqueue(object:Callback<Planeta?>{
                                override fun onResponse(call:Call<Planeta?>,response: Response<Planeta?>){
                                    Toast.makeText(binding.root.context, "Usted ha eliminado ha $nombrePlaneta", Toast.LENGTH_SHORT).show()
                                }
                                override fun onFailure(call:Call<Planeta?>,t:Throwable) {
                                    Toast.makeText(binding.root.context, "error", Toast.LENGTH_SHORT).show()
                                }
                            })
                            planeta.remove(planet)
                            this@AdapterPlaneta.notifyItemRemoved(position)
                        }
                        .setNegativeButton("Cancel") { _, _ ->
                            Toast.makeText(binding.root.context, "Usted ha cancelado la eliminacion", Toast.LENGTH_SHORT)
                                .show()
                        }.create().show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return planeta!!.size
    }

}