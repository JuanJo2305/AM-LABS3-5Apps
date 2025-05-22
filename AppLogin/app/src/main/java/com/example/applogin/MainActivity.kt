package com.example.applogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etContrasena = findViewById<EditText>(R.id.etContrasena)
        val btnIniciarSesion = findViewById<Button>(R.id.btnIniciarSesion)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnIniciarSesion.setOnClickListener {
            val usuario = etUsuario.text.toString().trim()
            val contrasena = etContrasena.text.toString().trim()

            if (usuario.isEmpty() || contrasena.isEmpty()) {
                tvResultado.text = "Campos vacíos: por favor completa ambos campos."
                tvResultado.setTextColor(Color.RED)
            } else {
                tvResultado.text = "Inicio de sesión exitoso para: $usuario"
                tvResultado.setTextColor(Color.GREEN)
            }
        }
    }
}