package com.example.conversordetemperatura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.conversordetemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding()
        onClickCalculate()
    }

    private fun onClickCalculate() {
        binding.button.setOnClickListener {
            calculateTemperature()
        }
    }

    private fun viewBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun calculateTemperature(){

        val value = binding.value.text.toString().toFloat()

        when (binding.temperature.isSelected){

        binding.celsiusForFahrenheit.isSelected
            -> binding.result.text = "Resultado: %.2f".format((value * 1.8)+ 32 ) // celsius para fahrenheit
        binding.celsiusForKelvin.isSelected
            -> binding.result.text = "Resultado: %.2f".format(value+273.15) // celsius para kelvin
        binding.kelvinForFahrenheit.isSelected
            -> binding.result.text = "Resultado: %.2f".format((1.8*(value-273))+32) // kelvin para fahrenheit
        binding.kelvinForCelsius.isSelected
            -> binding.result.text = "Resultado: %.2f".format(value - 273.15) // kelvin para celsius
        binding.fahrenheitForCelsius.isSelected
            -> binding.result.text = "Resultado: %.2f".format((value/ 1.8) + 32) // fahrenheit celsius
        binding.fahrenheitForKelvin.isSelected
            -> binding.result.text = "Resultado: %.2f".format((value + 459.67)*5/9) // fahrenheit para kelvin

           else -> {
               println("Error")
           }
       }
    }
}