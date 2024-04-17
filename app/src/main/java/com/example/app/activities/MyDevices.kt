package com.example.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R

class MyDevices : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_devices)

        val backButton: Button = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}