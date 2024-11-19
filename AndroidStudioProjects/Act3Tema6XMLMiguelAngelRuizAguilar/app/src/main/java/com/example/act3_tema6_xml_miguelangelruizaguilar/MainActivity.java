package com.example.act3_tema6_xml_miguelangelruizaguilar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        // Configuración del Toolbar
        Toolbar toolbar = findViewById(R.id.main);
        setSupportActionBar(toolbar);

        // Ajuste del padding para barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(toolbar, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView texto1 =findViewById(R.id.textoMenu);
        switch (item.getItemId()) {
            case R.id.Lunes:
                texto1.setText("Has pulsado: " +"lunes");
                return true;
            case R.id.Martes:
                texto1.setText("Has pulsado: " +" martes.");
                return true;
            case R.id.Miercoles:
                texto1.setText("Has pulsado: " +" miercoles.");
                return true;
            case R.id.Jueves:
                texto1.setText("Has pulsado: " +" jueves.");
                return true;
            case R.id.Viernes:
                texto1.setText("Has pulsado: " +" viernes.");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
