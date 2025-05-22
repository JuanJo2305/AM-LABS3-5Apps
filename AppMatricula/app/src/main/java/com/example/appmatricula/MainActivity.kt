package com.example.appmatricula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

data class Alumno(val codigo: String, val nombres: String, val correo: String, val direccion: String)

class MainActivity : AppCompatActivity() {

    private lateinit var etCodigo: EditText
    private lateinit var etNombres: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etDireccion: EditText
    private lateinit var btnMatricular: Button
    private lateinit var tvAlumnos: TextView
    private val alumnosList = mutableListOf<Alumno>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCodigo = findViewById(R.id.etCodigo)
        etNombres = findViewById(R.id.etNombres)
        etCorreo = findViewById(R.id.etCorreo)
        etDireccion = findViewById(R.id.etDireccion)
        btnMatricular = findViewById(R.id.btnMatricular)
        tvAlumnos = findViewById(R.id.tvAlumnos)

        btnMatricular.setOnClickListener {
            matricularAlumno()
        }
    }

    private fun matricularAlumno() {
        val codigo = etCodigo.text.toString()
        val nombres = etNombres.text.toString()
        val correo = etCorreo.text.toString()
        val direccion = etDireccion.text.toString()

        if (codigo.isEmpty() || nombres.isEmpty() || correo.isEmpty() || direccion.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        val nuevoAlumno = Alumno(codigo, nombres, correo, direccion)

        alumnosList.add(nuevoAlumno)

        actualizarListaAlumnos()

        etCodigo.text.clear()
        etNombres.text.clear()
        etCorreo.text.clear()
        etDireccion.text.clear()

        Toast.makeText(this, "Alumno matriculado correctamente.", Toast.LENGTH_SHORT).show()
    }

    private fun actualizarListaAlumnos() {
        val encabezado = "Código II Nombre II Correo II Dirección\n"

        val alumnosTexto = alumnosList.joinToString("\n") { alumno ->
            "${alumno.codigo} II ${alumno.nombres} II ${alumno.correo} II ${alumno.direccion}"
        }

        tvAlumnos.text = encabezado + alumnosTexto
    }




}