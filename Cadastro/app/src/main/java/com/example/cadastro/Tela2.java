package com.example.cadastro;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class Tela2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);


        Button Limpar = (Button) findViewById(R.id.Limpar);
        Button Enviar  = (Button) findViewById(R.id.Enviar);
        EditText et_valor1=(EditText) findViewById(R.id.edt_Nome);
        EditText et_valor2=(EditText) findViewById(R.id.edt_Sobrenome);
        EditText et_valor3=(EditText) findViewById(R.id.edt_Email);
        EditText et_valor4=(EditText) findViewById(R.id.edt_Senha);



        Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                et_valor1.setText(" ");
                et_valor2.setText(" ");
                et_valor3.setText(" ");
                et_valor4.setText(" ");
            }


        });
        Enviar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
    }

    });

  }

}
//Enviar.setOnClickListener(new View.OnClickListener() {
//    public class Enviar extends AppCompatActivity {
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.tela2);
//        }
//    }