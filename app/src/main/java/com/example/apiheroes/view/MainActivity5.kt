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
import com.example.apiheroes.Adapters.AdapterPoderes
import com.example.apiheroes.Adapters.AdapterTipoMision
import com.example.apiheroes.R
import com.example.apiheroes.databinding.ActivityMain3Binding
import com.example.apiheroes.databinding.ActivityMain5Binding
import com.example.apiheroes.modelos.Poderes
import com.example.apiheroes.modelos.TipoMision
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity5 : AppCompatActivity() {
    lateinit var binding: ActivityMain5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        pantalla_Completa()
        llenarRecyclear()
        binding.apply {
            btnBack.setOnClickListener{
                startActivity(Intent(this@MainActivity5,MainActivity2::class.java))
            }
            AddTipoMision.setOnClickListener {
                AddPoderes()
                textTipoMision.setText("")
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
        rutaAPI.builderTipoMision.get().enqueue(object: Callback<MutableList<TipoMision>?> {
            override fun onResponse(call: Call<MutableList<TipoMision>?>?, response: Response<MutableList<TipoMision>?>?){
                var tm=response?.body()?.toMutableList()
                binding.RecyclearTipoMision.layoutManager = LinearLayoutManager(this@MainActivity5)
                binding.RecyclearTipoMision.adapter = AdapterTipoMision(tm)
            }
            override fun onFailure(call: Call<MutableList<TipoMision>?>?, t:Throwable) {
                Toast.makeText(this@MainActivity5, "error", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun AddPoderes(){
        var data= TipoMision(0,binding.textTipoMision.text.toString())
        rutaAPI.builderTipoMision.insert(data).enqueue(object : Callback<TipoMision> {
            override fun onResponse(call: Call<TipoMision>, response: Response<TipoMision>) {}
            override fun onFailure(call: Call<TipoMision>, t: Throwable) {}
        })
    }
}