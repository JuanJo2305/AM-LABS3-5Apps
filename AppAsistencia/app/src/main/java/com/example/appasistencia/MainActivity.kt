package com.example.appasistencia

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.os.Bundle

data class Alumno(val codigo: String, val nombres: String)

class MainActivity : AppCompatActivity() {

    private lateinit var etCodigo: EditText
    private lateinit var etNombres: EditText
    private lateinit var btnMarcarAsistencia: Button
    private lateinit var tvAsistencia: TextView
    private val alumnosAsistidos = mutableListOf<Alumno>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCodigo = findViewById(R.id.etCodigo)
        etNombres = findViewById(R.id.etNombres)
        btnMarcarAsistencia = findViewById(R.id.btnMarcarAsistencia)
        tvAsistencia = findViewById(R.id.tvAsistencia)


        btnMarcarAsistencia.setOnClickListener {
            marcarAsistencia()
        }


    }

    private fun marcarAsistencia() {
        val codigo = etCodigo.text.toString()
        val nombres = etNombres.text.toString()

        if (codigo.isEmpty() || nombres.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese todos los datos.", Toast.LENGTH_SHORT).show()
            return
        }

        val nuevoAlumno = Alumno(codigo, nombres)

        alumnosAsistidos.add(nuevoAlumno)

        Toast.makeText(this, "Asistencia registrada para $nombres.", Toast.LENGTH_SHORT).show()

        mostrarAsistencia()

        etCodigo.text.clear()
        etNombres.text.clear()
    }

    private fun mostrarAsistencia() {
        val asistenciaTexto = alumnosAsistidos.joinToString("\n") { alumno ->
            "${alumno.codigo} - ${alumno.nombres}"
        }

        tvAsistencia.text = "Alumnos con asistencia:\n$asistenciaTexto"
    }

}