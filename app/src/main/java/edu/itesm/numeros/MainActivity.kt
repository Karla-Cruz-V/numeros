package edu.itesm.numeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import edu.itesm.numeros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var arreglo = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()

    }

    private fun initUI(){
        binding.promedio.setOnClickListener {
            promedio()
            Toast.makeText( this, "Se calculará el promedio", Toast.LENGTH_LONG).show()
        }
        binding.pares.setOnClickListener {
            promedioPares()
            Toast.makeText( this, "Promedio pares", Toast.LENGTH_LONG).show()
        }
        binding.mayor.setOnClickListener {
            numeroMayor()
            Toast.makeText( this, "Número mayor", Toast.LENGTH_LONG).show()
        }
        binding.agregar.setOnClickListener {
            val nuevoNum = binding.editTextNumberSigned.text.toString()
            arreglo.add(nuevoNum.toInt())
            Toast.makeText( this, "Se agregó número", Toast.LENGTH_LONG).show()
        }


    }

    private fun promedio(){
        val promedioNuevo = arreglo.average()
        binding.resultados.text= promedioNuevo.toString()
        binding.editTextNumberSigned.text = null
    }

    private fun promedioPares(){
    val pares = arreglo.filter { i -> i % 2 == 0 }
        val promPares = pares.average()
        binding.resultados.text= promPares.toString()
        binding.editTextNumberSigned.text = null

    }

    private fun numeroMayor(){
    val numMayor = arreglo.maxOrNull()
        binding.resultados.text= numMayor.toString()
        binding.editTextNumberSigned.text = null
    }





    }
