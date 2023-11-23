package com.example.apiheroes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.apiheroes.R
import com.example.apiheroes.databinding.ActivityMain2Binding
import com.example.apiheroes.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        pantalla_Completa()
        binding.apply {
            button.setOnClickListener {
                startActivity(Intent(this@MainActivity2,MainActivity3::class.java))
            }
            btnEquipo.setOnClickListener {
                startActivity(Intent(this@MainActivity2,MainActivity4::class.java))
            }
            btnTipoMision.setOnClickListener {
                startActivity(Intent(this@MainActivity2,MainActivity5::class.java))
            }
            btnPoderes.setOnClickListener {
                startActivity(Intent(this@MainActivity2,MainActivity6::class.java))
            }
            btnHeroes.setOnClickListener {
                startActivity(Intent(this@MainActivity2,MainActivity7::class.java))
            }
            btnPoderesHeroes.setOnClickListener {
                startActivity(Intent(this@MainActivity2,MainActivity8::class.java))
            }
            btnMisiones.setOnClickListener {
                startActivity(Intent(this@MainActivity2,MainActivity9::class.java))
            }
            btnMisionGrupal.setOnClickListener {
                startActivity(Intent(this@MainActivity2,MainActivity10::class.java))
            }
            btnMisionSolo.setOnClickListener {
                startActivity(Intent(this@MainActivity2,MainActivity11::class.java))
            }
            btnAgrupacion.setOnClickListener {
                startActivity(Intent(this@MainActivity2,MainActivity12::class.java))
            }
        }
    }
    fun pantalla_Completa(){
        WindowCompat.setDecorFitsSystemWindows(window,false)
        WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.systemBars())
    }
}