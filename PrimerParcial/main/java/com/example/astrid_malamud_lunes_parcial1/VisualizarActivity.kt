package com.example.astrid_malamud_lunes_parcial1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class VisualizarActivity : AppCompatActivity() {
    lateinit var tx_visualizar_usuario: TextView
    lateinit var tx_visualizar_compras:TextView
    lateinit var tx_visualizar_reservas:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar)

        tx_visualizar_compras = findViewById(R.id.tx_visualizar_compras)
        tx_visualizar_reservas = findViewById(R.id.tx_visualizar_reservas)
        val bt_visualizar_volver:Button = findViewById(R.id.bt_visualizar_volver)

        tx_visualizar_usuario = findViewById(R.id.tx_visualizar_usuario)
        var usuario:String = intent.getStringExtra("usu").toString()
        tx_visualizar_usuario.text = usuario

        cargarCompras()
        cargarReservas()
        bt_visualizar_volver.setOnClickListener(){
            var intentVolver:Intent = Intent(this, ActionActivity::class.java)
            intentVolver.putExtra("usuarioDos", tx_visualizar_usuario.text)
            startActivity(intentVolver)
        }

    }

    fun cargarCompras(){
        val preferences:SharedPreferences = getSharedPreferences("infoCompras", Context.MODE_PRIVATE)
        //Leer las preferencias
        var comp:String? = preferences.getString("cantCompras", "0")
        tx_visualizar_compras.setText(comp)
    }


    fun cargarReservas(){
        val preferences:SharedPreferences = getSharedPreferences("infoReservas", Context.MODE_PRIVATE)
        //Leer las preferencias
        var res:String? = preferences.getString("cantReservas", "0")
        tx_visualizar_reservas.setText(res)
    }

}