package com.example.appburbuja

import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etValor1 = findViewById<EditText>(R.id.etValor1)
        val etValor2 = findViewById<EditText>(R.id.etValor2)
        val etValor3 = findViewById<EditText>(R.id.etValor3)
        val etValor4 = findViewById<EditText>(R.id.etValor4)
        val etValor5 = findViewById<EditText>(R.id.etValor5)
        val btnOrdenar = findViewById<Button>(R.id.btnOrdenar)
        val btnOrdenarDesc = findViewById<Button>(R.id.btnOrdenarDesc)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnOrdenar.setOnClickListener {
            try {
                val numeros = listOf(
                    etValor1.text.toString().toDouble(),
                    etValor2.text.toString().toDouble(),
                    etValor3.text.toString().toDouble(),
                    etValor4.text.toString().toDouble(),
                    etValor5.text.toString().toDouble()
                ).toMutableList()

                // Algoritmo de ordenamiento burbuja
                for (i in 0 until numeros.size - 1) {
                    for (j in 0 until numeros.size - i - 1) {
                        if (numeros[j] > numeros[j + 1]) {
                            val temp = numeros[j]
                            numeros[j] = numeros[j + 1]
                            numeros[j + 1] = temp
                        }
                    }
                }

                tvResultado.text = "Resultado ascendente: ${numeros.joinToString(", ")}"
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa todos los valores correctamente",
                    Toast.LENGTH_SHORT).show()
            }
        }

        btnOrdenarDesc.setOnClickListener {
            try {
                val numeros = listOf(
                    etValor1.text.toString().toDouble(),
                    etValor2.text.toString().toDouble(),
                    etValor3.text.toString().toDouble(),
                    etValor4.text.toString().toDouble(),
                    etValor5.text.toString().toDouble()
                ).toMutableList()

                // Burbuja descendente
                for (i in 0 until numeros.size - 1) {
                    for (j in 0 until numeros.size - i - 1) {
                        if (numeros[j] < numeros[j + 1]) {
                            val temp = numeros[j]
                            numeros[j] = numeros[j + 1]
                            numeros[j + 1] = temp
                        }
                    }
                }

                tvResultado.text = "Resultado descendente: ${numeros.joinToString(", ")}"
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa todos los valores correctamente",
                    Toast.LENGTH_SHORT).show()
            }
        }


    }
}