package com.example.apiheroes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiheroes.API.rutaAPI
import com.example.apiheroes.Adapters.AdapterEquipo
import com.example.apiheroes.Adapters.AdapterPlaneta
import com.example.apiheroes.R
import com.example.apiheroes.databinding.ActivityMain3Binding
import com.example.apiheroes.databinding.ActivityMain4Binding
import com.example.apiheroes.modelos.Equipo
import com.example.apiheroes.modelos.Planeta
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity4 : AppCompatActivity() {
    lateinit var binding : ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        pantalla_Completa()
        llenarRecyclear()
        binding.apply {
            btnBack.setOnClickListener{
                startActivity(Intent(this@MainActivity4,MainActivity2::class.java))
            }
            AddEquipo.setOnClickListener {
                AddEquipo()
                textEquipo.setText("")
                llenarRecyclear()
            }
            btnRefresh.setOnClickListener {
                llenarRecyclear()
            }
            btnEliminar.setOnClickListener {

            }
        }
    }
    fun pantalla_Completa(){
        WindowCompat.setDecorFitsSystemWindows(window,false)
        WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.systemBars())
    }
    fun llenarRecyclear(){
        rutaAPI.builderEquipo.get().enqueue(object: Callback<MutableList<Equipo>?> {
            override fun onResponse(call: Call<MutableList<Equipo>?>?, response: Response<MutableList<Equipo>?>?){
                var team=response?.body()?.toMutableList()
                binding.RecyclearEquipo.layoutManager = LinearLayoutManager(this@MainActivity4)
                binding.RecyclearEquipo.adapter = AdapterEquipo(team)
            }
            override fun onFailure(call: Call<MutableList<Equipo>?>?, t:Throwable) {
                Toast.makeText(this@MainActivity4, "error", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun AddEquipo(){
        var data= Equipo(0,binding.textEquipo.text.toString())
        rutaAPI.builderEquipo.insert(data).enqueue(object : Callback<Equipo> {
            override fun onResponse(call: Call<Equipo>, response: Response<Equipo>) {}
            override fun onFailure(call: Call<Equipo>, t: Throwable) {}
        })
    }
}