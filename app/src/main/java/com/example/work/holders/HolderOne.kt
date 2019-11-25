package com.example.work.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.work.R

class HolderOne (itemView:View):RecyclerView.ViewHolder(itemView){
    var textOne: TextView? = null
    var textTwo: TextView? = null
    var textThree: TextView? = null

    init {
        textOne = itemView.findViewById(R.id.item_1)
        textTwo = itemView.findViewById(R.id.item_2)
        textThree = itemView.findViewById(R.id.item_3)
    }
}