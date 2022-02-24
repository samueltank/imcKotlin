package br.senai.imckotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RelatorioIMC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relatorio_imc)

        val nomeTextView = findViewById<TextView>(R.id.nome);
        var alturaTextView = findViewById<TextView>(R.id.altura);
        var pesoTextView = findViewById<TextView>(R.id.peso);
        var imcTextView = findViewById<TextView>(R.id.imc);
        var situacaoTextView = findViewById<TextView>(R.id.situacao);



        val intent: Intent = this.getIntent();
        nomeTextView.text = intent.getStringExtra("nome");
        alturaTextView.text = intent.getStringExtra("altura");
        pesoTextView.text = intent.getStringExtra("peso");
        imcTextView.text = intent.getStringExtra("imc");
        situacaoTextView.text = intent.getStringExtra("status");
    }
}