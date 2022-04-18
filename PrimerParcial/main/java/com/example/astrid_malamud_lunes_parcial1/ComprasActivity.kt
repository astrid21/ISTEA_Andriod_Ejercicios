package com.example.astrid_malamud_lunes_parcial1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ComprasActivity : AppCompatActivity() {
    lateinit var tx_compras_usuario: TextView
    lateinit var tx_compras_cant:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compras)

        val bt_compras_mas:Button = findViewById(R.id.bt_compras_mas)
        val bt_compras_menos:Button = findViewById(R.id.bt_compras_menos)
        tx_compras_cant = findViewById(R.id.tx_compras_cant)
        val bt_compras_guardar:Button = findViewById(R.id.bt_compras_guardar)

        tx_compras_usuario = findViewById(R.id.tx_compras_usuario)
        var usuario:String = intent.getStringExtra("usu").toString()
        tx_compras_usuario.text = usuario

        bt_compras_menos.isEnabled = false

        var compras:Int = 0

        bt_compras_mas.setOnClickListener(){
            if(compras<50){
                bt_compras_menos.isEnabled = true
                compras++
                tx_compras_cant.text = compras.toString()
            }else{
                bt_compras_mas.isEnabled = false
            }

        }

        bt_compras_menos.setOnClickListener(){
            if(compras>0){
                bt_compras_mas.isEnabled = true
                compras--
                tx_compras_cant.text = compras.toString()
            }else{
                bt_compras_menos.isEnabled = false
            }

        }

        bt_compras_guardar.setOnClickListener(){
            guardarCompras()
            var intentGuardarCompras:Intent = Intent(this, VisualizarActivity::class.java)
            intentGuardarCompras.putExtra("usu", tx_compras_usuario.text )
            startActivity(intentGuardarCompras)
        }
    }


    fun guardarCompras(){
        val preferences:SharedPreferences = getSharedPreferences("infoCompras", Context.MODE_PRIVATE)
        var cantidad_compras:String = tx_compras_cant.text.toString()
        // escribimos las preferencias
        var editor:SharedPreferences.Editor = preferences.edit()
        editor.putString("cantCompras", cantidad_compras)

        editor.commit()
    }

}