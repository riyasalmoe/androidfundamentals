package com.almoe.androidfundamentalscourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Affirmations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_affirmations)
//        val textView : TextView = findViewById(R.id.Affirmation_Size)
//        textView.text = DataSource().loadAffirmations().size.toString()
    }
}