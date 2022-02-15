package com.example.accountbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ProfileDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)

        val data = intent.getParcelableExtra<Account>("data")

        val content = findViewById<TextView>(R.id.detailContentText)
        val date = findViewById<TextView>(R.id.detailDateText)
        val goMenu = findViewById<Button>(R.id.detailGoMenuBtn)

        content.text = data?.content
        date.text = data?.date

        goMenu.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}