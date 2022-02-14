package com.example.accountbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class InsertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val insertBtn = findViewById<Button>(R.id.insertBtn)
        val pay = findViewById<EditText>(R.id.editPay)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val content = findViewById<EditText>(R.id.editContent)

        var type:String = ""

        radioGroup.setOnCheckedChangeListener{
                _, checkedId ->
            when(checkedId){
                R.id.inBtn -> type="수입"
                R.id.outBtn -> type="지출"
            }
        }


        insertBtn.setOnClickListener {

            var date = datePicker.year.toString() + "/" +
                    "" + (datePicker.month + 1).toString() + "/" + datePicker.dayOfMonth.toString()

            val account = Account(0, type, pay.text.toString().toInt(), date, content.text.toString())

            DBHelper.getInstance(this, "account.db").insert(account)

            Toast.makeText(this@InsertActivity, "입력되었습니다.", Toast.LENGTH_SHORT).show()
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)

        }
    }
}