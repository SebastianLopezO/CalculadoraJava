package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import static com.example.calculadora.R.id.Numero1;
import static com.example.calculadora.R.id.btnResta;

public class MainActivity extends AppCompatActivity {
    //definir variables
    private TextView TextResultado;
    private TextView TextSigno;

    private EditText EditNumero1;
    private EditText EditNumero2;

    private Button btnSuma;
    private Button btnResta;
    private Button btnMultiplicacion;
    private Button btnDivision;
    private Button btnBorrar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignar valores de id con variables
        TextResultado=findViewById(R.id.Resultado);
        TextSigno=findViewById(R.id.Signo);

        EditNumero1=findViewById(R.id.Numero1);
        EditNumero2=findViewById(R.id.Numero2);

        btnSuma= findViewById(R.id.btnSuma);
        btnResta= findViewById(R.id.btnResta);
        btnMultiplicacion= findViewById(R.id.btnMultiplicacion);
        btnDivision= findViewById(R.id.btnDivision);
        btnBorrar=findViewById(R.id.btnBorrar);


        //Funcion al dar click
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextResultado.setText("="+suma(Double.parseDouble(EditNumero1.getText().toString()), Integer.parseInt(EditNumero2.getText().toString()))+"");
                TextSigno.setText("+");
            }
        });
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextResultado.setText("="+resta(Double.parseDouble(EditNumero1.getText().toString()), Integer.parseInt(EditNumero2.getText().toString()))+"");
                TextSigno.setText("-");
            }
        });
        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextResultado.setText("="+multiplicacion(Double.parseDouble(EditNumero1.getText().toString()), Integer.parseInt(EditNumero2.getText().toString()))+"");
                TextSigno.setText("*");
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(EditNumero2.getText().toString())==0) {
                    TextSigno.setText("/");
                    TextResultado.setText("Math ERROR");
                } else{
                    TextResultado.setText("=" + division(Double.parseDouble(EditNumero1.getText().toString()), Integer.parseInt(EditNumero2.getText().toString())) + "");
                    TextSigno.setText("/");
                }
            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextResultado.setText("=");
                TextSigno.setText(" ");
                EditNumero1.getText().clear();
                EditNumero2.getText().clear();

            }
        });

    }
    //operaciones aritmeticas
    public double suma(double a, double b){
        return a+b;
    }
    public double resta(double a, double b){
        return a-b;
    }
    public double multiplicacion(double a, double b){
        return a*b;
    }
    public double division(double a, double b){
        return a / b;

    }
}