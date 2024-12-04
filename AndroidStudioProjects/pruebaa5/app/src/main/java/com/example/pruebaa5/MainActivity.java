package com.example.pruebaa5;

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
    Toolbar tb1;
    TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tb1 = findViewById(R.id.tb1);
        tx1 = findViewById(R.id.tx1);
        setSupportActionBar(tb1);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú
        getMenuInflater().inflate(R.menu.menu, menu);
        return true; // Importante para mostrar el menú
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejo de las opciones del menú
        switch (item.getItemId()) {
            case R.id.titulo1:
                tx1.setText("Has pulsado la opción 1" + item.getTitle());
                return true;
            case R.id.titulo2:
                tx1.setText("Has pulsado la opción 2");
                return true;
            case R.id.titulo3:
                tx1.setText("Has pulsado la opción 3");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}