package com.example.segundoparcial_malamudastrid_lunes

import android.app.Dialog
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class CompraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)

        val dni : String = intent.getStringExtra("dni").toString()
        val producto : String = intent.getStringExtra("producto").toString()
        val talle : String = intent.getStringExtra("talle").toString()

        val tx_producto : TextView = findViewById(R.id.tx_producto)
        val tx_talle : TextView = findViewById(R.id.tx_talle)

        val bt_guardar : Button = findViewById(R.id.bt_guardar)
        val bt_volver : Button = findViewById(R.id.bt_volver)
        val bt_salir : Button = findViewById(R.id.bt_salir)

        var guardado : Boolean = false

        tx_producto.setText(producto)
        tx_talle.setText(talle)

        var helper = MyDBhelper(this)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM COMPRAS", null)
        for(r in 1.. rs.count){
            if(rs.moveToNext()){
                Toast.makeText(this, rs.getString(1) + rs.getString(2),Toast.LENGTH_SHORT).show()
            }
        }

        bt_guardar.setOnClickListener(){
            if(guardado == false){
                var cv = ContentValues()
                cv.put("PRODUCTO", producto)
                cv.put("TALLE", talle)
                db.insert("COMPRAS", null, cv)

                Toast.makeText(this, "Producto guardado con exito", Toast.LENGTH_SHORT).show()
                guardado = true
            }else{
                var alert = AlertDialog.Builder(this)
                alert.setMessage("Esta seguro que desea volver a guardar el mismo producto y talle")
                    .setCancelable(false)
                    .setPositiveButton("Si", DialogInterface.OnClickListener(){
                            Dialog : DialogInterface, i : Int ->
                        var cv = ContentValues()
                        cv.put("PRODUCTO", producto)
                        cv.put("TALLE", talle)
                        db.insert("COMPRAS", null, cv)

                        Toast.makeText(this, "Producto guardado nuevamente con exito", Toast.LENGTH_SHORT).show()
                    })
                    .setNegativeButton("No", DialogInterface.OnClickListener(){
                            Dialog : DialogInterface, i : Int ->
                        Dialog.cancel()
                        bt_guardar.isEnabled = false
                    })
                var ventana : AlertDialog = alert.create()
                ventana.setTitle("Salida")
                ventana.show()
            }


        }

        bt_volver.setOnClickListener(){
            var intent : Intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("dni", dni)
            startActivity(intent)
        }

        bt_salir.setOnClickListener(){
            var alert = AlertDialog.Builder(this)
            alert.setMessage("Desea salir de la aplicacion?")
                .setCancelable(false)
                .setPositiveButton("Si", DialogInterface.OnClickListener(){
                    Dialog : DialogInterface, i : Int ->
                    finishAffinity()
                })
                .setNegativeButton("No", DialogInterface.OnClickListener(){
                    Dialog : DialogInterface, i : Int ->
                    Dialog.cancel()
                })
            var ventana : AlertDialog = alert.create()
            ventana.setTitle("Salida")
            ventana.show()
        }

    }
}