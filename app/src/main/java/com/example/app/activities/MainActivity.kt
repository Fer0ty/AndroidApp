package com.example.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val myDevicesButton: Button = findViewById(R.id.devices_button)
        val myRoomsButton: Button = findViewById(R.id.rooms_button)
        // Переход на страницу "Мои устройства"
        myDevicesButton.setOnClickListener {
            val intent = Intent(this, MyDevices::class.java)
            startActivity(intent)
        }
        // Переход на страницу "Комнаты"
        myRoomsButton.setOnClickListener {
            val intent = Intent(this, MyRooms::class.java)
            startActivity(intent)
        }

//        todo: notifications list

    }
}
