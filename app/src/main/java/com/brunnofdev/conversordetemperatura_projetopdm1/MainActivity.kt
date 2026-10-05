package com.brunnofdev.conversordetemperatura_projetopdm1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun removerVirgula(texto: String): String = texto.replace(",", ".")

    fun converterTemperatura(valor: Double, tipo1: String, tipo2: String): Double {
        
        if (tipo1 == tipo2) {
            return valor
        }
        if (tipo1 == "Celsius" && tipo2 == "Fahrenheit") {
            return (valor * 1.8) + 32
        } else if (tipo1 == "Celsius" && tipo2 == "Kelvin") {
            return valor + 273.15
        } else if (tipo1 == "Fahrenheit" && tipo2 == "Celsius") {
            return (valor - 32) / 1.8
        } else if (tipo1 == "Fahrenheit" && tipo2 == "Kelvin") {
            return (valor - 32) * 5/9 + 273.15
        } else if (tipo1 == "Kelvin" && tipo2 == "Celsius") {
            return valor - 273.15
        } else if (tipo1 == "Kelvin" && tipo2 == "Fahrenheit") {
            return (valor - 273.15) * 1.8 + 32
        } else {
            return 0.0
        }
    }
    
}