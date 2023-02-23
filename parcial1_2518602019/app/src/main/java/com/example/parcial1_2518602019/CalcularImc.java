package com.example.parcial1_2518602019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcularImc extends AppCompatActivity {


    private Button btnCalcular;

    private EditText tePeso, teEstatura;

    private TextView tvRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_imc);

        this.tePeso = findViewById(R.id.tePeso);
        this.teEstatura = findViewById(R.id.teEstatura);

        this.btnCalcular = findViewById(R.id.btnCalcular);

        this.tvRespuesta = findViewById(R.id.tvStatus);
    }

    public void calcularImc(View view){

        String pesoString = tePeso.getText().toString();
        String estaturaString = teEstatura.getText().toString();
        String respuesta = "";

        if(!pesoString.isEmpty() && !estaturaString.isEmpty()){
            double peso = Double.parseDouble(pesoString);
            double estatura = Double.parseDouble(estaturaString);

            double imc = Math.round(peso/((estatura/100)*2));

            //imc = Math.rint(imc*100)/100;

            respuesta = "Su indice es de: "+imc+ ", usted tiene: ";

            if(imc < 10.5) respuesta += "Críticamente Bajo de Peso";
            else if(imc < 15.9) respuesta += "Severamente Bajo de Peso";
            else if(imc < 18.5) respuesta += "Bajo de Peso";
            else if(imc < 25) respuesta += "Normal (peso saludable)";
            else if(imc < 30) respuesta += "Sobrepeso";
            else if(imc < 35) respuesta += "Obesidad Clase 1 - Moderadamente Obeso";
            else if(imc < 40) respuesta += "Obesidad Clase 2 - Severamente Obeso";
            else respuesta += "Obesidad Clase 3 - Críticamente Obeso";

        }else{
            respuesta = "por favor ingrese los datos de peso y estatura.";
        }

        this.tvRespuesta.setText(respuesta);
    }

}