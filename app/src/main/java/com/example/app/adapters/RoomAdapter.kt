package com.example.app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.models.Room

class RoomAdapter(private val context: Context, private val rooms: List<Room>) :
    RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_room, parent, false)
        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room = rooms[position]
        holder.bind(room)
    }

    override fun getItemCount(): Int {
        return rooms.size
    }

    inner class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val roomNameTextView: TextView = itemView.findViewById(R.id.roomNameTextView)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(room: Room) {
            roomNameTextView.text = room.name
        }

        override fun onClick(v: View) {
            val position = adapterPosition
            val room = rooms[position]
//            onRoomClickListener?.onRoomClick(position, room.name)
        }
    }


//    interface OnRoomClickListener {
//        fun onRoomClick(position: Int, roomName: String)
//    }
//
//    private var onRoomClickListener: OnRoomClickListener? = null
//
//    fun setOnRoomClickListener(listener: OnRoomClickListener) {
//        this.onRoomClickListener = listener
//    }


}
