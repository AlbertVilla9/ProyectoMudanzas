package com.example.proyectomudanzas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.proyectomudanzas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load("https://fedem.es/wp-content/uploads/2017/02/mudanzas-fedem-logo-empresa-mudanzas-sevilla-madrid.jpg")
            .centerCrop()
            .into(binding.imgLogin)

        binding.loginbtn.setOnClickListener{
            val i = Intent(this, MenuActivity::class.java)
            startActivity(i)
        }
    }
}