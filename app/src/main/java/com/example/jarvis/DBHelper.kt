package com.example.jarvis

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(ctx: Context) :
    SQLiteOpenHelper(ctx, "jarvis.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE books(title TEXT, page INT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, v1: Int, v2: Int) {}

    fun saveBook(title: String, page: Int) {
        writableDatabase.execSQL(
            "INSERT INTO books VALUES(?,?)",
            arrayOf(title, page)
        )
    }

    fun getLastPage(title: String): Int? {
        val c = readableDatabase.rawQuery(
            "SELECT page FROM books WHERE title=?",
            arrayOf(title)
        )
        return if (c.moveToFirst()) c.getInt(0) else null
    }
}
