package com.example.accountbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity2 : AppCompatActivity() {

    val AccountList =
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search2)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val searchBtn = findViewById<Button>(R.id.searchBtn)

        val adapter = CustomAdapter(this,accountList)
        recyclerView.adapter = adapter

        val layout = LinearLayoutManager(this)
        recyclerView.layoutManager = layout

        recyclerView.setHasFixedSize(true)

        searchBtn.setOnClickListener {
            var date = datePicker.year.toString() + "/" +
                    "" + (datePicker.month + 1).toString() + "/" + datePicker.dayOfMonth.toString()
            DBHelper.getInstance(this, "account.db").select()
        }
    }
}