package com.example.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R
import com.example.app.db.RoomDBHelper
import com.example.app.models.Room


class AddRoom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_room)
        val userData: EditText = findViewById(R.id.roomNameEnter)
        val addButton: Button = findViewById(R.id.add_button)
        val backButton: Button = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            intent = Intent(this, MyRooms::class.java)
            startActivity(intent)
        }

        addButton.setOnClickListener {
            val roomName = userData.text.toString()
            val roomDB = RoomDBHelper(this, null)
            if (roomName.isNotEmpty()) {
                val newRoom = Room(-1, roomName)
                roomDB.addRoom(newRoom)
                Toast.makeText(this, "Комната успешно добавлена", Toast.LENGTH_SHORT).show()
                intent = Intent(this, MyRooms::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Введите название комнаты", Toast.LENGTH_SHORT).show()
            }
        }


    }
}