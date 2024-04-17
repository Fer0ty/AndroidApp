package com.example.app.activities

import android.os.Bundle
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R

class AddNewDevice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_new_device)
        var deviceTypeSpinner: Spinner = findViewById(R.id.deviceTypeSpinner)
        var roomSpinner: Spinner = findViewById(R.id.roomSpinner)
//        todo: complete...

    }
}