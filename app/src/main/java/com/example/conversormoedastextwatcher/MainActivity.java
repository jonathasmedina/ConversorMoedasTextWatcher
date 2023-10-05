package com.example.conversormoedastextwatcher;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextReal, editTextDolar, editTextEuro, editTextGuarani;

    double cambio;
    boolean real = false;
    boolean dolar = false;
    boolean euro = false;
    boolean guarani = false;

    /*
        1 Dólar americano igual a 5,17 Real brasileiro
        1 Dólar americano igual a 7.310,79 Guarani paraguaio
        1 Dólar americano igual a 0,95 Euro

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDolar = findViewById(R.id.editTextText2);
        editTextEuro = findViewById(R.id.editTextText3);
        editTextGuarani = findViewById(R.id.editTextText4);
        editTextReal = findViewById(R.id.editTextText);


        editTextReal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!dolar){
                    if(editTextReal.getText().length() > 0){
                        real = true;

                        cambio = Double.parseDouble(editTextReal.getText().toString())/5.17;
                        editTextDolar.setText(String.format("%.4f", cambio));
                    }
                    else
                    editTextDolar.setText("");

                }
                //coloca cursor no final do campo
                editTextReal.setSelection(editTextReal.getText().length());
                real = false;


            }
        });

        editTextDolar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //variável para controle de quem está sendo alterado
                dolar = true;

                if(!real){
                    if(editTextDolar.getText().length() > 0){
                        cambio = Double.parseDouble(editTextDolar.getText().toString())/5.17;
                        editTextReal.setText(String.format("%.4f", cambio));
                        real = false;
                    }
                    else
                    editTextReal.setText("");
                }

                if(!guarani){
                    if(editTextDolar.getText().length() > 0){
                        cambio = Double.parseDouble(editTextDolar.getText().toString())/0.00014;

                        editTextGuarani.setText(String.format("%.4f", cambio));
                        guarani = false;
                    }
                    else
                        editTextGuarani.setText("");

                }

                if(!euro){
                    if(editTextDolar.getText().length() > 0){
                        cambio = Double.parseDouble(editTextDolar.getText().toString())/0.95;

                        editTextEuro.setText(String.format("%.4f", cambio));
                        euro = false;
                    }
                    else
                        editTextEuro.setText("");

                }
                dolar = false;
            }
        });

        editTextEuro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!dolar){
                    if(editTextEuro.getText().length() > 0){
                        euro = true;
                        cambio = Double.parseDouble(editTextEuro.getText().toString())/0.95;

                        editTextDolar.setText(String.format("%.4f", cambio));
                    }
                    else
                        editTextDolar.setText("");
                }
                editTextEuro.setSelection(editTextEuro.getText().length());
                euro = false;

            }
        });


        editTextGuarani.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!dolar){
                    if(editTextGuarani.getText().length() > 0){
                        guarani = true;
                        cambio = Double.parseDouble(editTextGuarani.getText().toString())/0.00014;

                        editTextDolar.setText(String.format("%.4f", cambio));
                    }
                    else
                        editTextDolar.setText("");
                }
                editTextGuarani.setSelection(editTextGuarani.getText().length());
                guarani = false;
            }
        });

    }
}