package com.example.act3_tema6_xml_miguelangelruizaguilar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
        String mensaje = "Has elegido el día: ";
        switch (item.getItemId()) {
            case R.id.Lunes:
                Toast.makeText(this, mensaje + "lunes", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Martes:
                Toast.makeText(this, mensaje + "martes", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Miercoles:
                Toast.makeText(this, mensaje + "miércoles", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Jueves:
                Toast.makeText(this, mensaje + "jueves", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Viernes:
                Toast.makeText(this, mensaje + "viernes", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
