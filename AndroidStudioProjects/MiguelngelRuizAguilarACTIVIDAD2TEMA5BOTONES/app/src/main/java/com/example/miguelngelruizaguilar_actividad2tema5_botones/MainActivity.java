package com.example.miguelngelruizaguilar_actividad2tema5_botones;


import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Referencia al TextView y a los botones
        TextView statusText = findViewById(R.id.statusText);
        Button button1 = findViewById(R.id.bt1);
        Button button2 = findViewById(R.id.bt2);


        // Configuración de la acción al pulsar el botón 1
        button1.setOnClickListener(v -> {
            statusText.setText("BOTÓN 1 PULSADO");
            statusText.setTextColor(Color.RED);
        });


        // Configuración de la acción al pulsar el botón 2
        button2.setOnClickListener(v -> {
            statusText.setText("BOTÓN 2 PULSADO");
            statusText.setTextColor(Color.GREEN);
        });
    }
}


