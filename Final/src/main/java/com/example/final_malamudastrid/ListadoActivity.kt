package com.example.final_malamudastrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        var arrayParticipantes : ArrayList<String> = intent.getStringArrayListExtra("arrayParticipantes") as ArrayList<String>


        val lv_participantes : ListView = findViewById(R.id.lv_participantes)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayParticipantes)

        lv_participantes.adapter = adaptador
    }
}