package com.example.apiheroes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
        init()
        llenarRecyclear()
    }
    fun pantalla_Completa(){
        WindowCompat.setDecorFitsSystemWindows(window,false)
        WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.systemBars())
    }
    fun llenarRecyclear(){
        rutaAPI.builderPlaneta.get().enqueue(object:Callback<List<Planeta>>{
            override fun onResponse(call:Call<List<Planeta>>,response: Response<List<Planeta>>){
                var planet=response.body()
                binding.RecyclearPlaneta.layoutManager = LinearLayoutManager(this@MainActivity3)
                binding.RecyclearPlaneta.adapter =AdapterPlaneta(planet)
            }
            override fun onFailure(call:Call<List<Planeta>>,t:Throwable) {
                Toast.makeText(this@MainActivity3, "error", Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun init() {
        var recuest = rutaAPI.builderPlaneta.get()
        recuest.enqueue(object : Callback<List<Planeta>> {
            override fun onResponse(call: Call<List<Planeta>>, response: Response<List<Planeta>>) {
                var planeta=response.body()
                Toast.makeText(this@MainActivity3, "conecto", Toast.LENGTH_SHORT).show()
                planeta?.forEach {
                    binding.apply {
                            textPlaneta.setText("${it.nombrePlaneta} \n")
                    }

                }

            }

            override fun onFailure(call: Call<List<Planeta>>, t: Throwable) {
                t.message?.let { Log.e("Desconectado", it) }
            }

        })
    }
}