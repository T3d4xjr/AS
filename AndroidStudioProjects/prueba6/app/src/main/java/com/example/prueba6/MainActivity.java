package com.example.prueba6;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar tb1;
    TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb1 = findViewById(R.id.tb1);  // Asegúrate de que este ID esté correcto en tu layout
        tx1 = findViewById(R.id.tx1);  // Asegúrate de que este ID esté correcto en tu layout
        setSupportActionBar(tb1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú desde el archivo XML
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejo de las opciones del menú
        switch (item.getItemId()) {
            case R.id.titulo1:
                tx1.setText("Has pulsado la opción 1: " + item.getTitle());
                return true;
            case R.id.titulo2:
                tx1.setText("Has pulsado la subopción 1 del submenú");
                return true;
            case R.id.titulo3:
                tx1.setText("Has pulsado la subopción 2 del submenú");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
