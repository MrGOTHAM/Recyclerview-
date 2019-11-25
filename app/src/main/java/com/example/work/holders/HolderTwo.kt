package com.example.work.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.work.R

class HolderTwo (itemView:View):RecyclerView.ViewHolder(itemView){
    var textTwo: TextView? = null

    init {
//        textTwo= itemView.findViewById(R.id.item_head)
    }
}