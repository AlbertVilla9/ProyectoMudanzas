package com.example.proyectomudanzas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectomudanzas.databinding.ActivityMainBinding
import com.example.proyectomudanzas.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}