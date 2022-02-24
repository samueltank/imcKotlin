package br.senai.imckotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
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
        val btnSairButton = findViewById<Button>(R.id.btnSair);

        btnSairButton.setOnClickListener { finish() };

        btnCalcButton.setOnClickListener {
            nameEditText       = findViewById(R.id.textName);
            alturaEditText     = findViewById(R.id.textAltura);
            pesoEditText       = findViewById(R.id.textPeso);

            var altura: Double = convertToStringToDouble(alturaEditText);
            var peso: Double   = convertToStringToDouble(pesoEditText);

            var imc: Double         = calcImc(peso, altura);
            var classImcTxt: String = classiImc(imc);

            var intent = Intent(this, RelatorioIMC::class.java);

            intent.putExtra("nome", nameEditText.text.toString());
            intent.putExtra("altura", altura.toString());
            intent.putExtra("peso", peso.toString());
            intent.putExtra("imc", formatNum(imc).toString());
            intent.putExtra("status", classImcTxt);

            startActivity(intent);

//            areaOutputTextView.text = classImcTxt;
        }
    }

    private fun calcImc(peso: Double, altura: Double) : Double
    {
        return (peso / altura.pow(2));
    }

    private fun classiImc (imcInput: Double) : String
    {
        val imc = imcInput;
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

    private fun convertToStringToDouble(variable: EditText) : Double
    {
        var vari: Double = variable.text.toString().toDouble();
        return vari;
    }

    private fun formatNum(num: Double) : Double  {
        val df = DecimalFormat("##.##");
        df.roundingMode = RoundingMode.HALF_UP;
        val result = df.format(num).toDouble();
        return result;
    }
}