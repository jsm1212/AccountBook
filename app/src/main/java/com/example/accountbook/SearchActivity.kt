package com.example.accountbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val datePicker = findViewById<DatePicker>(R.id.datePicker1)
        val searchBtn = findViewById<Button>(R.id.normalSearchBtn)
        val MenuBtn = findViewById<Button>(R.id.goMenuBtn)

        searchBtn.setOnClickListener {
            var date = datePicker.year.toString() +
                    (datePicker.month + 1).toString() +  datePicker.dayOfMonth.toString()

            val adapter = CustomAdapter(this)
            recyclerView.adapter = adapter

            val layout = LinearLayoutManager(this)
            recyclerView.layoutManager = layout

            recyclerView.setHasFixedSize(true)

            adapter.dataList.addAll(DBHelper.getInstance(this, "account.db").select(date))
        }

        MenuBtn.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

}