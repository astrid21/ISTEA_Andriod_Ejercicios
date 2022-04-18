package com.example.astrid_malamud_lunes_parcial1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ReservasActivity : AppCompatActivity() {
    lateinit var tx_reservas_usuario: TextView
    lateinit var tx_reservas_cant: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservas)

        val bt_reservas_mas: Button = findViewById(R.id.bt_reservas_mas)
        val bt_reservas_menos: Button = findViewById(R.id.bt_reservas_menos)
        tx_reservas_cant = findViewById(R.id.tx_reservas_cant)
        val bt_reservas_guardar: Button = findViewById(R.id.bt_reservas_guardar)

        tx_reservas_usuario = findViewById(R.id.tx_reservas_usuario)
        var usuario:String = intent.getStringExtra("usu").toString()
        tx_reservas_usuario.text = usuario

        bt_reservas_menos.isEnabled = false

        var reservas:Int = 0

        bt_reservas_mas.setOnClickListener(){
            if(reservas<10){
                bt_reservas_menos.isEnabled = true
                reservas++
                tx_reservas_cant.text = reservas.toString()
            }else{
                bt_reservas_mas.isEnabled = false
            }

        }

        bt_reservas_menos.setOnClickListener(){
            if(reservas>0){
                bt_reservas_mas.isEnabled = true
                reservas--
                tx_reservas_cant.text = reservas.toString()
            }else{
                bt_reservas_menos.isEnabled = false
            }

        }

        bt_reservas_guardar.setOnClickListener(){
            guardarReservas()
            var intentGuardarCompras: Intent = Intent(this, VisualizarActivity::class.java)
            intentGuardarCompras.putExtra("usu", tx_reservas_usuario.text )
            startActivity(intentGuardarCompras)
        }
    }

    fun guardarReservas(){
        val preferences: SharedPreferences = getSharedPreferences("infoReservas", Context.MODE_PRIVATE)
        var cantidad_reservas:String = tx_reservas_cant.text.toString()
        // escribimos las preferencias
        var editor: SharedPreferences.Editor = preferences.edit()
        editor.putString("cantReservas", cantidad_reservas)

        editor.commit()
    }
}