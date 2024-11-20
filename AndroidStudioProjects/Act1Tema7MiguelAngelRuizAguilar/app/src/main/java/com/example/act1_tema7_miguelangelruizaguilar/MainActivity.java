package com.example.act1_tema7_miguelangelruizaguilar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton1 = findViewById(R.id.boton1);
        boton1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EditTextActivity.class);
            startActivity(intent);
        });

        Button boton2 = findViewById(R.id.boton2);
        boton2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SeekBarActivity.class);
            startActivity(intent);
        });
    }
}