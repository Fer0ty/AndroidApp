package com.example.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.EditRoom
import com.example.app.R
import com.example.app.adapters.RoomAdapter
import com.example.app.db.RoomDBHelper

class MyRooms : AppCompatActivity(){
    val db = RoomDBHelper(this, null)
    val rooms = db.getAllRooms()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_rooms)
        val recyclerView: RecyclerView = findViewById(R.id.roomsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RoomAdapter(this, rooms)
        recyclerView.adapter = adapter

        val addButton: Button = findViewById(R.id.add_button)
        val backButton: Button = findViewById(R.id.backButton)

//        addButton.setOnClickListener {
//            intent = Intent(this, AddRoom::class.java)
//            startActivity(intent)
//        }

        backButton.setOnClickListener {
            finish()
        }

    }

//    override fun onRoomClick(position: Int, roomName: String) {
//        val intent = Intent(this, EditRoom::class.java)
//        intent.putExtra("roomPosition", position)
//        intent.putExtra("roomName", roomName)
//        startActivity(intent)
//    }

}

