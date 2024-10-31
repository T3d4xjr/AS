package com.example.act3tema5miguelangelruizaguilar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTexto1;
    private TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincular los elementos de la interfaz
        editTexto1 = findViewById(R.id.editTexto1);
        textView1 = findViewById(R.id.textView1);


        String cadenaTexto =editTexto1.getText().toString();
        editTexto1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            textView1.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}