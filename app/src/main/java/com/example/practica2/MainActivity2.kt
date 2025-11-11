package com.example.practica2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val  nombre = findViewById<TextView>(R.id.nombreTextView)
        val biografia = findViewById<TextView>(R.id.biografiaTextView)

            biografia.text="Joevn de 20 años apasionado con la programacion"

        val botonEditar=findViewById<Button>(R.id.botonEditar)
        val botonCompartir=findViewById<Button>(R.id.botonCompartir)

        botonEditar.setOnClickListener {
            val intentoEditar=Intent(this, pantallaEdicion::class.java)
            intentoEditar.putExtra("Nombre_Actual",nombre.text.toString())
            intentoEditar.putExtra("Biografia_Actual ",biografia.text.toString())
            startActivity(intentoEditar)
        }

        botonCompartir.setOnClickListener {
            val shareText="${nombre.text}\n\n${biografia.text}"
            val shareIntent=Intent(Intent.ACTION_SEND).apply {
                type="text/plain"
                putExtra(Intent.EXTRA_TEXT,shareText)

            }

            startActivity(Intent.createChooser(shareIntent,"Compartir biografia con "))
        }


    }
}