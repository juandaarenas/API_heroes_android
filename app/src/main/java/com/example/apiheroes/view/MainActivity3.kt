package com.example.apiheroes.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiheroes.API.rutaAPI
import com.example.apiheroes.Adapters.AdapterPlaneta
import com.example.apiheroes.databinding.ActivityMain3Binding
import com.example.apiheroes.modelos.Planeta
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity3 : AppCompatActivity() {
    lateinit var binding : ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        pantalla_Completa()
        llenarRecyclear()
        binding.apply {
            btnBack.setOnClickListener{
                startActivity(Intent(this@MainActivity3,MainActivity2::class.java))
            }
            AddPlanet.setOnClickListener {
                AddPlaneta()
                textPlaneta.setText("")
                llenarRecyclear()
            }
            btnRefresh.setOnClickListener {
                llenarRecyclear()
            }
        }
    }
    fun pantalla_Completa(){
        WindowCompat.setDecorFitsSystemWindows(window,false)
        WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.systemBars())
    }
    fun llenarRecyclear(){
        rutaAPI.builderPlaneta.get().enqueue(object:Callback<MutableList<Planeta>?>{
            override fun onResponse(call:Call<MutableList<Planeta>?>?,response: Response<MutableList<Planeta>?>?){
                var planet=response?.body()?.toMutableList()
                binding.RecyclearPlaneta.layoutManager = LinearLayoutManager(this@MainActivity3)
                binding.RecyclearPlaneta.adapter =AdapterPlaneta(planet)
            }
            override fun onFailure(call:Call<MutableList<Planeta>?>?,t:Throwable) {
                Toast.makeText(this@MainActivity3, "error", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun AddPlaneta(){
        var data= Planeta(0,binding.textPlaneta.text.toString())
        rutaAPI.builderPlaneta.insert(data).enqueue(object : Callback<Planeta> {
            override fun onResponse(call: Call<Planeta>, response: Response<Planeta>) {}
            override fun onFailure(call: Call<Planeta>, t: Throwable) {}
        })
    }
    fun eliminarElemento(id: Int) {
        val call = rutaAPI.builderPlaneta.Delete(id)/*
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {}
            override fun onFailure(call: Call<Void>, t: Throwable) {}
        })*/
    }
}
