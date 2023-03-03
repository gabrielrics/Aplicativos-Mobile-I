package com.example.api_calculo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //definindo variaveis - Globais
    double vnum1,vnum2, vresul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Código Calculadora

        Button bnt_somar = (Button) findViewById(R.id.bnt_somar);
        Button bnt_subtrair = (Button) findViewById(R.id.bnt_subtrair);
        Button bnt_multiplicar = (Button) findViewById(R.id.bnt_multiplicar);
        Button bnt_dividir = (Button) findViewById(R.id.bnt_dividir);
        Button bnt_reset = (Button) findViewById(R.id.bnt_reset);
        EditText et_valor1=(EditText) findViewById(R.id.et_valor1);
        EditText et_valor2=(EditText) findViewById(R.id.ed_valor2);

        TextView tv_resultado=(TextView) findViewById(R.id.tv_resultado);

        //Rotina de soma
        bnt_somar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vnum1 = Double.parseDouble(et_valor1.getText().toString());
                vnum2 = Double.parseDouble(et_valor2.getText().toString());
                vresul = vnum1 + vnum2;
                tv_resultado.setText(String.valueOf(vresul));
            }
        });

        //Rotina Subtrair
        bnt_subtrair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vnum1 = Double.parseDouble(et_valor1.getText().toString());
                vnum2 = Double.parseDouble(et_valor2.getText().toString());
                vresul = vnum1 - vnum2;
                tv_resultado.setText(String.valueOf(vresul));
            }
        });

        //Rotina Multplicar
        bnt_multiplicar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vnum1 = Double.parseDouble(et_valor1.getText().toString());
                vnum2 = Double.parseDouble(et_valor2.getText().toString());
                vresul = vnum1 * vnum2;
                tv_resultado.setText(String.valueOf(vresul));
            }
        });

        //Rotina dividir
        bnt_dividir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vnum1 = Double.parseDouble(et_valor1.getText().toString());
                vnum2 = Double.parseDouble(et_valor2.getText().toString());
                vresul = vnum1 / vnum2;
                tv_resultado.setText(String.valueOf(vresul));
            }
        });
        //Rotina Reset
        bnt_reset.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               vnum1 = Double.parseDouble(et_valor1.getText().toString());
               vnum2 = Double.parseDouble(et_valor2.getText().toString());
               vresul = 0;
               tv_resultado.setText(String.valueOf(""));
            }
        });


    }
}