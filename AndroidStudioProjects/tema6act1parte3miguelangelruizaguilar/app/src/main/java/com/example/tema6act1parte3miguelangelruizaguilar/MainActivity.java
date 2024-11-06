package com.example.tema6act1parte3miguelangelruizaguilar;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner listado;
    TextView textSelecciona;
    final String[] datos = new String[]{"Argentina", "Peru", "España", "Francia", "Alemania", "Italia", "Canada", "Venezuela", "Mexico", "Chile"};
    final int[] colores = {
            0xFFFFCDD2, 0xFFF8BBD0, 0xFFE1BEE7, 0xFFD1C4E9,
            0xFFC5CAE9, 0xFFBBDEFB, 0xFFB3E5FC, 0xFFB2EBF2,
            0xFFB2DFDB, 0xFFC8E6C9
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listado = findViewById(R.id.listado);
        textSelecciona = findViewById(R.id.textSelecciona);

        // Adaptador personalizado en línea
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                view.setBackgroundColor(colores[position % colores.length]); // Asigna un color diferente según la posición
                return view;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                view.setBackgroundColor(colores[position % colores.length]); // Asigna un color diferente en el menú desplegable
                return view;
            }
        };

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listado.setAdapter(adaptador);

        listado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int posicion, long id) {
                String elemento = (String) parent.getItemAtPosition(posicion);
                textSelecciona.setText("Seleccionaste: " + elemento);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textSelecciona.setText("Selecciona un país");
            }
        });
    }
}
