package com.example.app.db;

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.app.models.Room


public class RoomDBHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "app"
        private const val TABLE_ROOMS = "rooms"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery =
            "CREATE TABLE $TABLE_ROOMS ($KEY_ID INTEGER PRIMARY KEY, $KEY_NAME TEXT)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ROOMS")
        onCreate(db)
    }

    fun addRoom(room: Room) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(KEY_NAME, room.name)
        }
        db.insert(TABLE_ROOMS, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllRooms(): List<Room> {
        val roomList = mutableListOf<Room>()
        val selectQuery = "SELECT * FROM $TABLE_ROOMS"
        val db = this.readableDatabase
        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: Exception) {
            db.execSQL(selectQuery)
            return emptyList()
        }

        cursor?.use {
            if (it.moveToFirst()) {
                do {
                    val id = it.getInt(it.getColumnIndex(KEY_ID))
                    val name = it.getString(it.getColumnIndex(KEY_NAME))
                    val room = Room(id, name)
                    roomList.add(room)
                } while (it.moveToNext())
            }
        }

        db.close()
        return roomList
    }

    fun deleteRoom(roomId: Int): Int {
        val db = writableDatabase
        val result = db.delete(TABLE_ROOMS, "$KEY_ID = ?", arrayOf(roomId.toString()))
        db.close()
        return result
    }

//    todo: rename room fun


}
