package com.example.work.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.work.R

class HolderHeader(itemView:View) :RecyclerView.ViewHolder(itemView){
    var textHeader: TextView? = null

    init {
        textHeader = itemView.findViewById(R.id.item_header)
    }
}