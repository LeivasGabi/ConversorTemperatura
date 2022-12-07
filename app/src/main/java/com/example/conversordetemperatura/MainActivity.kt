package com.example.conversordetemperatura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conversordetemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root

        setContentView(view)

        binding.button.setOnClickListener {
            converteTemperatura()
        }
    }
    fun converteTemperatura(){

        var valor = binding.valor.text.toString().toFloat()

        var temperatura: Boolean = binding.temperatura.isSelected


       when (temperatura){

        binding.cParaF.isSelected
            -> binding.resultado.text = "Resultado: %.2f".format((valor * 1.8)+ 32 ) // celsius para fahrenheit
        binding.cParaK.isSelected
            -> binding.resultado.text = "Resultado: %.2f".format(valor+273.15) // celsius para kelvin
        binding.kParaF.isSelected
            -> binding.resultado.text = "Resultado: %.2f".format((1.8*(valor-273))+32) // kelvin para fahrenheit
        binding.kParaC.isSelected
            -> binding.resultado.text = "Resultado: %.2f".format(valor - 273.15) // kelvin para celsius
        binding.fParaC.isSelected
            -> binding.resultado.text = "Resultado: %.2f".format((valor/ 1.8) + 32) // fahrenheit celsius
        binding.fParaK.isSelected
            -> binding.resultado.text = "Resultado: %.2f".format((valor + 459.67)*5/9) // fahrenheit para kelvin

           else -> {
               println("Error")
           }
       }
    }
}