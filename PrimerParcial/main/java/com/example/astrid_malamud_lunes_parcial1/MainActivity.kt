package com.example.astrid_malamud_lunes_parcial1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed_usuario:EditText = findViewById(R.id.ed_usuario)
        val ed_clave:EditText = findViewById(R.id.ed_clave)
        val bt_ingresar:Button = findViewById(R.id.bt_ingresar)
        val tx_usuario:TextView = findViewById(R.id.tx_usuario)
        var usuario:String? = intent.getStringExtra("usu").toString()
        if(usuario !== "null"){
            tx_usuario.text = usuario
        }

        bt_ingresar.setOnClickListener(){
            if(ed_usuario.text.toString() == "Istea" && ed_clave.text.toString() == "1234"){
                tx_usuario.text = "Usuario: " + ed_usuario.text

                var intentIngresar:Intent = Intent(this, ActionActivity::class.java)
                intentIngresar.putExtra("usuario", tx_usuario.text)
                startActivity(intentIngresar)
            }else{
                tx_usuario.text = "Usuario Incorrecto! El usuaio correcto es Istea y la clave es 1234 ;)"
            }


        }
    }
}