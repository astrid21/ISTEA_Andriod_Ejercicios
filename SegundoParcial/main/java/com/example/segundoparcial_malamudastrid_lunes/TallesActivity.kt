package com.example.segundoparcial_malamudastrid_lunes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class TallesActivity : AppCompatActivity() {
    lateinit var lv_talles : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talles)

        lv_talles = findViewById(R.id.lv_talles)
        var dni : String = intent.getStringExtra("dni").toString()
        val producto : String = intent.getStringExtra("producto").toString()

        val tx_dni_talles : TextView = findViewById(R.id.tx_dni_talles)
        tx_dni_talles.setText("DNI: " + dni)

        val tx_produ_talles : TextView = findViewById(R.id.tx_produ_talles)
        tx_produ_talles.setText("Producto Seleccionado: " + producto)

        val talles = arrayOf(35, 36, 37, 38, 39, 40, 41, 42, 43)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, talles)

        lv_talles.adapter = adaptador

        lv_talles.setOnItemClickListener{
                parent, view, position, id ->

            var intent : Intent = Intent(this, CompraActivity::class.java)
            intent.putExtra("dni", dni)
            intent.putExtra("producto", producto)
            intent.putExtra("talle", parent.getItemAtPosition(position).toString())
            startActivity(intent)
        }
    }
}