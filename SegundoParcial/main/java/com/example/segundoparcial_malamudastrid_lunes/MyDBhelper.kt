package com.example.segundoparcial_malamudastrid_lunes

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBhelper(context: Context) : SQLiteOpenHelper(context, "COMPRASDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE COMPRAS (COMPRAID INTEGER PRIMARY KEY AUTOINCREMENT, PRODUCTO TEXT, TALLE INTEGER)")




    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}