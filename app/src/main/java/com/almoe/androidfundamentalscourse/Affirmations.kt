package com.almoe.androidfundamentalscourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.almoe.androidfundamentalscourse.adapter.ItemAdapter
import com.almoe.androidfundamentalscourse.data.DataSource


class Affirmations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_affirmations)
//        val textView : TextView = findViewById(R.id.Affirmation_Size)
//        textView.text = DataSource().loadAffirmations().size.toString()

        //initialize data
        val myDataset = DataSource().loadAffirmations()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
    }
}