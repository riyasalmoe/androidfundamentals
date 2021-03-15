package com.almoe.androidfundamentalscourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SingleActivityApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_app)
    }
}