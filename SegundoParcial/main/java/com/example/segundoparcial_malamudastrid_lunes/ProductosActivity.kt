package com.example.segundoparcial_malamudastrid_lunes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class ProductosActivity : AppCompatActivity() {
    lateinit var lv_productos : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        lv_productos = findViewById(R.id.lv_productos)
        var dni : String = intent.getStringExtra("dni").toString()
        val tx_dni_produ : TextView = findViewById(R.id.tx_dni_produ)
        tx_dni_produ.setText("DNI: " + dni)

        val productos = arrayOf("Zapatillas", "Zapato", "Chinela", "Zandalia", "Borcegos", "Botas de lluvia", "Botas", "Tacones")

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, productos)

        lv_productos.adapter = adaptador

        lv_productos.setOnItemClickListener{
            parent, view, position, id ->

            var intent : Intent = Intent(this, TallesActivity::class.java)
            intent.putExtra("dni", dni)
            intent.putExtra("producto", parent.getItemAtPosition(position).toString())
            startActivity(intent)
        }

    }
}