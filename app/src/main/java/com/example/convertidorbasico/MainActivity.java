package com.example.convertidorbasico;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] opciones = {"Convertir Kilometros a Metros", "Convertir Metros a Kilometros"};
    Spinner objSpinner;
    TextView objLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objSpinner = findViewById(R.id.listaConversion);
        ArrayAdapter<String> elAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        elAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        objSpinner.setAdapter(elAdaptador);

        Button elBoton = findViewById(R.id.btnCalcular);
        elBoton.setBackgroundColor(Color.BLUE);
        objLabel = findViewById(R.id.lblResultados);

        elBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opcionSeleccionada = objSpinner.getSelectedItemPosition();
                EditText objCantidad = findViewById(R.id.txtCantidad);

                try {
                    double cantidad = Double.parseDouble(objCantidad.getText().toString());
                    double resultado;
                    String abreviatura;

                    switch (opcionSeleccionada) {
                        case 0: // Kilometros a Metros
                            resultado = cantidad * 1000;
                            abreviatura = "MTS";
                            break;
                        case 1: // Metros a Kilometros
                            resultado = cantidad / 1000;
                            abreviatura = "KMS";
                            break;
                        default:
                            resultado = 0;
                            abreviatura = "";
                    }
                    objLabel.setText("Resultado: " + resultado + " " + abreviatura);
                } catch (NumberFormatException e) {
                    objLabel.setText("Error: Ingresa un número válido");
                }
            }
        });
    }
}
