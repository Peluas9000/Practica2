package com.example.practica2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pantallaEdicion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_edicion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botonGuardar=findViewById<Button>(R.id.guardarCambios)
        val nombreEdit=findViewById<EditText>(R.id.nombreEdit)
        val bioEdit=findViewById<EditText>(R.id.biografiaEdit)



        botonGuardar.setOnClickListener {
            val nombre=nombreEdit.text.toString()
            val bio=bioEdit.text.toString()
            val intent= Intent(this,MainActivity2::class.java)

            intent.putExtra("nombre",nombre)
            intent.putExtra("biografia",bio)

            startActivity(intent)

        }


    }
}