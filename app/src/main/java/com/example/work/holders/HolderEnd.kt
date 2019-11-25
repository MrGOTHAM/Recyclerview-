package com.example.work.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.work.R

class HolderEnd (itemView:View):RecyclerView.ViewHolder(itemView){

    var textEnd: TextView? = null

    init {
        textEnd = itemView.findViewById(R.id.item_end)
    }
}