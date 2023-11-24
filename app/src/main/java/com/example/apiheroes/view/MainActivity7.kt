package com.example.apiheroes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiheroes.API.rutaAPI
import com.example.apiheroes.Adapters.AdapterHeroes
import com.example.apiheroes.Adapters.AdapterPlaneta
import com.example.apiheroes.Adapters.AdapterPoderes
import com.example.apiheroes.R
import com.example.apiheroes.databinding.ActivityMain6Binding
import com.example.apiheroes.databinding.ActivityMain7Binding
import com.example.apiheroes.modelos.Heroes
import com.example.apiheroes.modelos.Planeta
import com.example.apiheroes.modelos.Poderes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity7 : AppCompatActivity() {
    lateinit var binding: ActivityMain7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)
        pantalla_Completa()
        llenarRecyclear()
        llenarspinner()
        binding.apply {
            btnBack.setOnClickListener{
                startActivity(Intent(this@MainActivity7,MainActivity2::class.java))
            }
            AddHeroes.setOnClickListener {
                AddHeroes()
                textHeroes.setText("")
                textEdad.setText("")
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
        rutaAPI.builderHeroes.get().enqueue(object: Callback<MutableList<Heroes>?> {
            override fun onResponse(call: Call<MutableList<Heroes>?>?, response: Response<MutableList<Heroes>?>?){
                var hero=response?.body()?.toMutableList()
                binding.RecyclearHeroes.layoutManager = LinearLayoutManager(this@MainActivity7)
                binding.RecyclearHeroes.adapter = AdapterHeroes(hero)
            }
            override fun onFailure(call: Call<MutableList<Heroes>?>?, t:Throwable) {
                Toast.makeText(this@MainActivity7, "error", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun AddHeroes(){
        var edad= binding.textEdad.text.toString().toInt()
        var planeta = binding.spnPlaneta.selectedItem as Planeta
        var data= Heroes(0,binding.textHeroes.text.toString(),edad,planeta.id)
        rutaAPI.builderHeroes.insert(data).enqueue(object : Callback<Heroes> {
            override fun onResponse(call: Call<Heroes>, response: Response<Heroes>) {}
            override fun onFailure(call: Call<Heroes>, t: Throwable) {}
        })
    }
    fun llenarspinner(){
        rutaAPI.builderPlaneta.get().enqueue(object:Callback<MutableList<Planeta>?>{
            override fun onResponse(call:Call<MutableList<Planeta>?>?, response: Response<MutableList<Planeta>?>?){
                var planet=response?.body()?.toMutableList()
                binding.spnPlaneta.adapter = ArrayAdapter<Planeta>(this@MainActivity7,android.R.layout.simple_spinner_dropdown_item, planet!!)
            }
            override fun onFailure(call:Call<MutableList<Planeta>?>?, t:Throwable) {
                Toast.makeText(this@MainActivity7, "error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}