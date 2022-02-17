package br.senai.imckotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity()
{
    private lateinit var nameEditText: EditText;
    private lateinit var alturaEditText: EditText;
    private lateinit var pesoEditText: EditText;
    private lateinit var areaOutputTextView: TextView;

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcButton = findViewById<Button>(R.id.btnCalc);
        val btnSairButton = findViewById<Button>(R.id.btnSair).setOnClickListener { finish() };

        btnCalcButton.setOnClickListener {
            nameEditText       = findViewById(R.id.textName);
            alturaEditText     = findViewById(R.id.textAltura);
            pesoEditText       = findViewById(R.id.textPeso);
            areaOutputTextView = findViewById(R.id.areaOutput);

            var altura: Double = convertToStringToInt(pesoEditText);
            var peso: Double   = convertToStringToInt(alturaEditText);

            var imc: Double         = calcImc(peso, altura);
            var classImcTxt: String = classiImc(imc);

            areaOutputTextView.text = classImcTxt;
        }
    }

    private fun calcImc(peso: Double, altura: Double) : Double
    {
        return (peso / altura.pow(2));
    }

    private fun classiImc (imc: Double) : String
    {
        var text: String = "";
        if(imc <= 18.5) {
            text = "Você está abaixo do peso";
        } else if(imc <= 25) {
            text = "Seu peso está normal!";
        } else if(imc <= 30) {
            text = "Você sofre de sobrepeso";
        } else if(imc <= 35) {
            text = "Você sobre de obesidade tipo I";
        } else if(imc <= 40) {
            text = "Você sofre de obesidade tipo II";
        } else {
            text = "Você sofre de obesidade tipo III";
        }
        return text;
    }

    private fun convertToStringToInt(variable: EditText) : Double
    {
        val vari = variable.text.toString().toDouble();
        return vari;
    }
}