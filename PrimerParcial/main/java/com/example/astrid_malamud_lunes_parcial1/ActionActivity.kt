package com.example.astrid_malamud_lunes_parcial1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class ActionActivity : AppCompatActivity() {
    lateinit var tx_action_usuario:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)
        tx_action_usuario = findViewById(R.id.tx_action_usuario)
        var usuario:String = intent.getStringExtra("usuario").toString()
        if(usuario == "null"){
            usuario = intent.getStringExtra("usuarioDos").toString()
        }
        tx_action_usuario.text = usuario
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true;
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var intentNav:Intent
        return when(item.itemId){
            R.id.nav_principal -> {
                intentNav = Intent(this, MainActivity::class.java)
                intentNav.putExtra("usu", tx_action_usuario.text )
                startActivity(intentNav)
                true
            }
            R.id.nav_comprar -> {
                intentNav = Intent(this, ComprasActivity::class.java)
                intentNav.putExtra("usu", tx_action_usuario.text )
                startActivity(intentNav)

                true
            }
            R.id.nav_reservar -> {
                intentNav = Intent(this, ReservasActivity::class.java)
                intentNav.putExtra("usu", tx_action_usuario.text )
                startActivity(intentNav)
                true
            }
            R.id.nav_visualizar -> {
                intentNav = Intent(this, VisualizarActivity::class.java)
                intentNav.putExtra("usu", tx_action_usuario.text )
                startActivity(intentNav)
                true
            }
            else -> false
        }


    }

}