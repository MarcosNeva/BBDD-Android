package com.example.practica01.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica01.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, HomeFragment()).commit()
    }
}
