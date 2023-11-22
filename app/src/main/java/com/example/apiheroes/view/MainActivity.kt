package com.example.apiheroes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.apiheroes.R
import com.example.apiheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pantalla_Completa()
        binding.splash.animate().setStartDelay(1000).setDuration(6000).withEndAction {
            startActivity(Intent(this,MainActivity2::class.java))
        }.start()
    }
    fun pantalla_Completa(){
        WindowCompat.setDecorFitsSystemWindows(window,false)
        WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.systemBars())
    }
}