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
import com.example.apiheroes.Adapters.AdapterPoderes
import com.example.apiheroes.R
import com.example.apiheroes.databinding.ActivityMain3Binding
import com.example.apiheroes.databinding.ActivityMain6Binding
import com.example.apiheroes.modelos.Equipo
import com.example.apiheroes.modelos.Poderes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity6 : AppCompatActivity() {
    lateinit var binding: ActivityMain6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        pantalla_Completa()
        llenarRecyclear()
        binding.apply {
            btnBack.setOnClickListener{
                startActivity(Intent(this@MainActivity6,MainActivity2::class.java))
            }
            AddPoderes.setOnClickListener {
                AddPoderes()
                textPoderes.setText("")
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
        rutaAPI.builderPoderes.get().enqueue(object: Callback<MutableList<Poderes>?> {
            override fun onResponse(call: Call<MutableList<Poderes>?>?, response: Response<MutableList<Poderes>?>?){
                var power=response?.body()?.toMutableList()
                binding.RecyclearPoderes.layoutManager = LinearLayoutManager(this@MainActivity6)
                binding.RecyclearPoderes.adapter = AdapterPoderes(power)
            }
            override fun onFailure(call: Call<MutableList<Poderes>?>?, t:Throwable) {
                Toast.makeText(this@MainActivity6, "error", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun AddPoderes(){
        var data= Poderes(0,binding.textPoderes.text.toString())
        rutaAPI.builderPoderes.insert(data).enqueue(object : Callback<Poderes> {
            override fun onResponse(call: Call<Poderes>, response: Response<Poderes>) {}
            override fun onFailure(call: Call<Poderes>, t: Throwable) {}
        })
    }
}