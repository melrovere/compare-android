package com.curso.android.app.practica.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.curso.android.app.practica.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparison.observe(this) {
            println("Resultado de comparacion de textos. $it")
            binding.resultado.text = it.description
        }

        binding.compararButton.setOnClickListener {
            Log.d("comparar", "click")
            mainViewModel.compare(binding.texto1.text.toString(), binding.texto2.text.toString())
        }
    }

}