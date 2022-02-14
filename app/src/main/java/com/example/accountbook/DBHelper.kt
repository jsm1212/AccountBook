package com.example.accountbook

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context:Context, filename:String) : SQLiteOpenHelper(context,filename,null,1) {

    companion object{
        private var dbhelper:DBHelper? = null
        fun getInstance(context:Context, filename: String) : DBHelper {
            if(dbhelper == null){
                dbhelper = DBHelper(context, filename)
            }
            return dbhelper!!
        }
    }
    override fun onCreate(db: SQLiteDatabase?) {
        var sql:String = " CREATE TABLE if not exists ACCOUNT( " +
                "  seq integer primary key autoincrement, " +
                "  type string, " +
                "  pay integer, " +
                "  date string, " +
                "  content string ) "
        db?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insert(vo:Account){
        var sql = " INSERT INTO ACCOUNT(type, pay, date, content) " +
                "   VALUES('${vo.type}', ${vo.pay}, '${vo.date}', '${vo.content}' ) "
        var db = this.writableDatabase
        db.execSQL(sql)
    }

    @SuppressLint("Range")
    fun select(vo: Account) : MutableList<Account> {
        val list = mutableListOf<Account>()
        var sql = " SELECT * FROM ACCOUNT WHERE DATE"
        var db = this.readableDatabase
        var cursor = db.rawQuery(sql, null)

        while(cursor.moveToNext()){
            val type = cursor.getString(cursor.getColumnIndex("type"))
            val pay = cursor.getInt(cursor.getColumnIndex("pay"))
            val date = cursor.getString(cursor.getColumnIndex("date"))
            val content = cursor.getString(cursor.getColumnIndex("content"))

            list.add(Account(0, type, pay, date, content))
        }
        return list
    }

}