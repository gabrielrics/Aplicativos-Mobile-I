package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    Button btsomar, btsubtrair,btmultiplicar, btdividir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btsubtrair,btmultiplicar, btdividir, btsomar;


            btsomar = (Button) findViewById(R.id.btsomar);

            btsubtrair = (Button) findViewById(R.id.btsubtrair);

            btmultiplicar=(Button)findViewById(R.id.btmultiplicar);

            btdividir = (Button) findViewById(R.id.btdividir);

            btsomar.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                }
            });

            btsubtrair.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {

                    BreakIterator ednumero1 = null;
                    double num1 = Double.parseDouble
                            (ednumero1.getText().toString());

                    BreakIterator ednumero2 = null;
                    double num2 = Double.parseDouble
                            (ednumero2.getText().toString());

                    double soma = num1 - num2;

                    AlertDialog.Builder dialogo = new
                            AlertDialog.Builder(MainActivity.this);

                    dialogo.setTitle("Resultado subtração");

                    dialogo.setMessage("A subtração é " + soma);

                    dialogo.setNeutralButton("OK", null);

                });

    }
}