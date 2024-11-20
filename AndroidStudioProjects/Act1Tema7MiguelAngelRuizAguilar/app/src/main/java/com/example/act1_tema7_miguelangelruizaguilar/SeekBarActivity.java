package com.example.act1_tema7_miguelangelruizaguilar;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SeekBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        // Configurar título en el Toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Activity con SeekBar");
        }

        // Configurar el SeekBar
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String position;
                int gravity;
                if (progress < 33) {
                    position = "Abajo";
                    gravity = android.view.Gravity.BOTTOM;
                } else if (progress < 66) {
                    position = "Centrado";
                    gravity = android.view.Gravity.CENTER;
                } else {
                    position = "Arriba";
                    gravity = android.view.Gravity.TOP;
                }

                Toast toast = Toast.makeText(SeekBarActivity.this, position, Toast.LENGTH_SHORT);
                toast.setGravity(gravity, 0, 200);
                toast.show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}