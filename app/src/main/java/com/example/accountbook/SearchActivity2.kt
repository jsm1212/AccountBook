package com.example.accountbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search2)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val startDatePicker = findViewById<DatePicker>(R.id.datePicker2)
        val endDatePicker = findViewById<DatePicker>(R.id.datePicker3)
        val searchBtn = findViewById<Button>(R.id.searchBtn)
        val MenuBtn = findViewById<Button>(R.id.goMenuBtn2)


        searchBtn.setOnClickListener {
            var startDate = startDatePicker.year.toString() +
                     (startDatePicker.month + 1).toString() +  startDatePicker.dayOfMonth.toString()

            var endDate = endDatePicker.year.toString() +
                      (endDatePicker.month + 1).toString() + endDatePicker.dayOfMonth.toString()

            val adapter = CustomAdapter(this)
            recyclerView.adapter = adapter

            val layout = LinearLayoutManager(this)
            recyclerView.layoutManager = layout

            recyclerView.setHasFixedSize(true)

            adapter.dataList.addAll(DBHelper.getInstance(this, "account.db").selectRange(startDate, endDate))


        }

        MenuBtn.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}