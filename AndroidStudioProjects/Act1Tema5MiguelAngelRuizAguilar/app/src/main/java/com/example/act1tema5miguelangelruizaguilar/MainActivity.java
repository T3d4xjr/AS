package com.example.act1tema5miguelangelruizaguilar;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the TextView and apply the custom font
        TextView textView = findViewById(R.id.textView4);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.UmbrellaRegular); // Ensure this matches the new file name

        // Check if the typeface is loaded successfully
        if (typeface != null) {
            textView.setTypeface(typeface);
        } else {
            // Use default typeface if custom font fails to load
            textView.setTypeface(Typeface.DEFAULT);
        }
    }
}
