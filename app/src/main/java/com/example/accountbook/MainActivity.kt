package com.example.accountbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goInsert = findViewById<Button>(R.id.goInsert)
        val goSearch = findViewById<Button>(R.id.goSearch)
        val goSearch2 = findViewById<Button>(R.id.goSearch2)

        goInsert.setOnClickListener {
            val i = Intent(this, InsertActivity::class.java)
            startActivity(i)
        }

        goSearch.setOnClickListener {
            val i = Intent(this, SearchActivity::class.java)
            startActivity(i)
        }

        goSearch2.setOnClickListener {
            val i = Intent(this, SearchActivity2::class.java)
            startActivity(i)
        }

    }
}