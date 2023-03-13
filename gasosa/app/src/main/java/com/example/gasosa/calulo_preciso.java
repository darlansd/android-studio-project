package com.example.gasosa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class calulo_preciso extends AppCompatActivity {

    EditText preco_gasolina,preco_alcool,km_p_alcool,km_p_gasosa;
    TextView txt_resultado, titulo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calulo_preciso);

        km_p_alcool = findViewById(R.id.edt_km_por_alcool);
        km_p_gasosa = findViewById(R.id.edt_km_gasosa);
        preco_gasolina = findViewById(R.id.edt_preco_gasolina);
        preco_alcool = findViewById(R.id.edt_preco_alcool);
        txt_resultado = findViewById(R.id.txt_resultado);
        titulo = findViewById(R.id.txt_titulo);

    }

    public void calcularpreco(View view){

        String precoalcool = preco_alcool.getText().toString();
        String precogasolina = preco_gasolina.getText().toString();

        boolean resultado = validar(precoalcool, precogasolina);

        if(resultado){
            double valoralcool = Double.parseDouble(precoalcool);
            double valorgasolina = Double.parseDouble(precogasolina);

            double resulteido = valoralcool / valorgasolina;

            if(resulteido >= 0.7) {
                Toast.makeText(getApplicationContext(),"usar gasolina",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),"usar alcool",Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(getApplicationContext(), "!PREENCHA OS CAMPOS PRIMEIRO!", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean validar (String pAlcool, String pGasolina){

        boolean validados = true;

        if (pAlcool == null || pAlcool.equals("")) {
            validados = false;

        }else if(pGasolina == null || pAlcool.equals("")){
            validados = false;
        };

        return validados;

    };
}