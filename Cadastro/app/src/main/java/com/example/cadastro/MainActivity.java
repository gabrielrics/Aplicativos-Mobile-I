package com.example.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btBotao = findViewById(R.id.Botao);                 //R é uma classe.
        btBotao.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                tela2();

            }
        });
    }

    private void tela2(){


        Intent it = new Intent(  this, Tela2.class);
        startActivityForResult(it, 1);

    }
}