package com.example.act1_tema7_prefereytoastmiguelangelruizaguilar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SeekBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String position;
                int gravity;
                int yOffset;

                if (progress < 33) {
                    position = "Abajo";
                    gravity = Gravity.BOTTOM;
                    yOffset = 100;
                } else if (progress < 66) {
                    position = "Centrado";
                    gravity = Gravity.CENTER;
                    yOffset = 0;
                } else {
                    position = "Arriba";
                    gravity = Gravity.TOP;
                    yOffset = 100;
                }

                showCustomToast(position, gravity, yOffset);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        Button backButton = findViewById(R.id.mainMenuButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(SeekBarActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void showCustomToast(String message, int gravity, int yOffset) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container));

        TextView textView = layout.findViewById(R.id.toast_text);
        textView.setText(message);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.setGravity(gravity, 0, yOffset);
        toast.show();
    }
}
