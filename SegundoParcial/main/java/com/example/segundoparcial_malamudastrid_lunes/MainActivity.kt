package com.example.segundoparcial_malamudastrid_lunes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed_dni : EditText = findViewById(R.id.ed_dni)
        val bt_comenzar : Button = findViewById(R.id.bt_comenzar)

        bt_comenzar.isEnabled = false

        ed_dni.addTextChangedListener() {
            if(ed_dni.text.toString().isNotEmpty()){
                bt_comenzar.isEnabled = true
            }
        }

        bt_comenzar.setOnClickListener(){
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("dni", ed_dni.text.toString())
            startActivity(intent)
        }
    }
}