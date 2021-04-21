package com.almoe.androidfundamentalscourse.adapter

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.almoe.androidfundamentalscourse.R
import com.almoe.androidfundamentalscourse.model.Affirmation

class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) {
class ItemViewHolder(private val view:View):RecyclerView.ViewHolder(view){
    val textView : TextView = view.findViewById(R.id.item_title)
}
}