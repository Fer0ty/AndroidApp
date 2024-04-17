package com.example.app

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.app.activities.MyRooms
import com.example.app.models.Room
import androidx.appcompat.app.AlertDialog
import com.example.app.db.RoomDBHelper

class EditRoom : AppCompatActivity() {
    val roomPosition = intent.getIntExtra("roomPosition", -1)
    val roomName = intent.getStringExtra("roomName")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_room)
        val backButton: Button = findViewById(R.id.backButton)
        val deleteButton: Button = findViewById(R.id.delete)
        val userData: EditText = findViewById(R.id.roomNameEnter)
        val header: TextView = findViewById(R.id.header)
        header.text = roomName

        backButton.setOnClickListener{
            finish()
        }

        deleteButton.setOnClickListener{
            showDeleteConfirmationDialog()
        }


    }
    private fun showDeleteConfirmationDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.apply {
            setTitle("Подтверждение удаления")
            setMessage("Вы уверены, что хотите удалить этот элемент?")
            setPositiveButton("Да") { dialogInterface: DialogInterface, _: Int ->
                dialogInterface.dismiss()
//                deleteRoom()
            }
            setNegativeButton("Отмена") { dialogInterface: DialogInterface, _: Int ->
                dialogInterface.dismiss()
            }
            create().show()
        }
    }

//    // Функция для удаления комнаты из списка и базы данных
//    private fun deleteRoom() {
//        // Удаление из списка (если нужно)
//        if (roomPosition != -1) {
//            // Удалите комнату из списка по ее позиции
//            // Например, если у вас есть MutableList<Room> rooms:
//            // rooms.removeAt(roomPosition)
//        }
//
//        // Удаление из базы данных (если нужно)
//        val roomDb = RoomDBHelper(this)
//        val roomId = roomDb.getRoomIdByName(roomName ?: "")
//        roomDb.deleteRoom(roomId)
//        finish()
//    }
}