package com.example.final_malamudastrid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed_nombre: EditText = findViewById(R.id.ed_nombre)
        val ed_apellido: EditText = findViewById(R.id.ed_apellido)
        val ed_edad: EditText = findViewById(R.id.ed_edad)
        val bt_agregar: Button = findViewById(R.id.bt_agregar)
        val bt_mostrar: Button = findViewById(R.id.bt_mostrar)
        val tx_info: TextView = findViewById(R.id.tx_info)

        var cant_participantes : Int = 0
        var arrayParticipantes : ArrayList<String> = ArrayList(5)



        bt_agregar.setOnClickListener(){
            if(ed_nombre.text.isNullOrEmpty() || ed_apellido.text.isNullOrEmpty() || ed_edad.text.isNullOrEmpty()){
                tx_info.text = "No han completado todos los campos"
            }else if(ed_edad.text.toString().toInt() < 21 || ed_edad.text.toString().toInt() > 50){
                tx_info.text = "El participante no se puede agregar por no tener entre 21 y 50"
                ed_nombre.setText("")
                ed_apellido.setText("")
                ed_edad.setText("")
            }else if(cant_participantes == 5){
                tx_info.text = "No se pueden agregar mas participantes"
                bt_agregar.isEnabled = false
            }else{
                arrayParticipantes.add(ed_nombre.text.toString() + "  " + ed_apellido.text.toString() + "  (" + ed_edad.text.toString() + ")" )
                tx_info.text = "PARTICIPANTE AGREGADO CON EXITO"
                ed_nombre.setText("")
                ed_apellido.setText("")
                ed_edad.setText("")
                cant_participantes++
            }
        }

        bt_mostrar.setOnClickListener(){

            if(cant_participantes != 0){
                var intent: Intent = Intent(this, ListadoActivity::class.java)
                intent.putExtra("arrayParticipantes", arrayParticipantes)

                startActivity(intent)

            }
            else{
            tx_info.text = "No hay participantes"

        }
        }




    }
}