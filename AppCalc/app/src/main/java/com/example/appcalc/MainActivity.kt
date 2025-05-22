package com.example.appcalc

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var etValorA: EditText
    private lateinit var etValorB: EditText
    private lateinit var etValorC: EditText
    private lateinit var tvResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etValorA = findViewById(R.id.etValorA)
        etValorB = findViewById(R.id.etValorB)
        etValorC = findViewById(R.id.etValorC)
        tvResultado = findViewById(R.id.tvResultado)

        val btnSumar = findViewById<Button>(R.id.btnCalcularSuma)
        val btnRestar = findViewById<Button>(R.id.btnCalcularResta)
        val btnMultiplicar = findViewById<Button>(R.id.btnCalcularMultiplicacion)
        val btnDividir = findViewById<Button>(R.id.btnCalcularDivision)

        btnSumar.setOnClickListener { calcularOperacion("sumar") }
        btnRestar.setOnClickListener { calcularOperacion("restar") }
        btnMultiplicar.setOnClickListener { calcularOperacion("multiplicar") }
        btnDividir.setOnClickListener { calcularOperacion("dividir") }
    }

    private fun calcularOperacion(operacion: String) {

        val valorA = etValorA.text.toString()
        val valorB = etValorB.text.toString()
        val valorC = etValorC.text.toString()


        if (valorA.isEmpty() || valorB.isEmpty() || valorC.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa los tres valores.", Toast.LENGTH_SHORT).show()
            return
        }

        val numA = valorA.toDoubleOrNull()
        val numB = valorB.toDoubleOrNull()
        val numC = valorC.toDoubleOrNull()

        if (numA == null || numB == null || numC == null) {
            Toast.makeText(this, "Por favor, ingresa valores válidos.", Toast.LENGTH_SHORT).show()
            return
        }

        var resultado: Double? = null

        when (operacion) {
            "sumar" -> resultado = numA + numB + numC
            "restar" -> resultado = numA - numB - numC
            "multiplicar" -> resultado = numA * numB * numC
            "dividir" -> {
                // Validar división por cero
                if (numB == 0.0 || numC == 0.0) {
                    Toast.makeText(this, "No se puede dividir por cero.", Toast.LENGTH_SHORT).show()
                    return
                }
                resultado = numA / numB / numC
            }
        }

        tvResultado.text = "Resultado: $resultado"
    }


}