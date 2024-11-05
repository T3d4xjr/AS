// MainActivity.java
package com.example.act1_tema6_parte1_miguelangelruizaguiar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView listado;
    TextView textSelecciona;
    final String[] datos = new String[]{"Argentina", "Peru", "España", "Francia", "Alemania", "Italia", "Canada", "Venezuela", "Mexico", "Chile"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar el diseño primero
        setContentView(R.layout.activity_main);

        // Inicializar el ListView después de setContentView
        listado = findViewById(R.id.lista);
        textSelecciona=findViewById(R.id.textSelecciona);


        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);
        listado.setAdapter(adaptador);


        ViewCompat.setOnApplyWindowInsetsListener(listado, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
            textSelecciona.getText();
            String elemento =(String) parent.getAdapter().getItem(posicion);
            }
        });

    }
}
