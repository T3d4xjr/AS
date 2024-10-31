package com.example.miguelngelruizaguilar_actividad2tema5_botonesparte3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isBt1Pressed = false;
    private boolean isBt2Pressed = false;
    private int counter1 = 0;
    private int counter2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = findViewById(R.id.bt1);
        Button bt2 = findViewById(R.id.bt2);
        TextView statusText1 = findViewById(R.id.statusText1);
        TextView statusText2 = findViewById(R.id.statusText2);
        TextView text1 = findViewById(R.id.text1);
        TextView texto2 = findViewById(R.id.texto2);
        TextView counterText1 = findViewById(R.id.counter1);
        TextView counterText2 = findViewById(R.id.counter2);

        // Configuración para el primer botón
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1++;  // Incrementa el contador del botón 1
                counterText1.setText(String.valueOf(counter1));

                // Cambia el color del contador según sea par o impar
                if (counter1 % 2 == 0) {
                    counterText1.setTextColor(Color.BLUE);
                } else {
                    counterText1.setTextColor(Color.GREEN);
                }

                text1.setText("BOTÓN 1 PULSADO");
                text1.setTextColor(Color.RED);
                if (isBt1Pressed) {
                    statusText1.setText("Sin pulsar");
                } else {
                    statusText1.setText("Pulsado");
                }
                isBt1Pressed = !isBt1Pressed;
            }
        });

        // Configuración para el segundo botón
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;  // Incrementa el contador del botón 2
                counterText2.setText(String.valueOf(counter2));

                // Cambia el color del contador según sea par o impar
                if (counter2 % 2 == 0) {
                    counterText2.setTextColor(Color.BLUE);
                } else {
                    counterText2.setTextColor(Color.GREEN);
                }

                texto2.setText("BOTÓN 2 PULSADO");
                texto2.setTextColor(Color.GREEN);
                if (isBt2Pressed) {
                    statusText2.setText("Sin pulsar");
                } else {
                    statusText2.setText("Pulsado");
                }
                isBt2Pressed = !isBt2Pressed;
            }
        });
    }
}
