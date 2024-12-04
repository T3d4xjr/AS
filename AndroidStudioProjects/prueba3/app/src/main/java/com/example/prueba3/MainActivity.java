package com.example.prueba3;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button bt1;
    Button bt2;
    ToggleButton toggleButton;
    ImageButton ib1;
    EditText et1;
    Spinner sp1;
    CheckBox cb1;

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
        tv1 = findViewById(R.id.textView);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        toggleButton = findViewById(R.id.tg1);
        ib1 = findViewById(R.id.ib1);
        et1= findViewById(R.id.et1);
        sp1= findViewById(R.id.sp1);
        cb1= findViewById(R.id.cb1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("Boton 1 Pulsado");
                tv1.setTextSize(20);
                tv1.setTextColor(Color.GRAY);
                tv1.setBackgroundColor(Color.BLUE);
                bt1.setEnabled(false);
                bt2.setEnabled(true);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("Boton 2 Pulsado");
                tv1.setTextSize(20);
                tv1.setTextColor(Color.WHITE);
                tv1.setBackgroundColor(Color.RED);
                bt2.setEnabled(false);
                bt1.setEnabled(true);
            }
        });
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("Toggle pulsado");
                tv1.setTextSize(20);
                if (toggleButton.isChecked()) {
                    tv1.setTextColor(Color.WHITE);
                    tv1.setBackgroundColor(Color.GREEN);

                } else {
                    tv1.setTextColor(Color.BLACK);
                    tv1.setBackgroundColor(Color.WHITE);


                }

            }
        });
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("Imagen pulsada");
                tv1.setTextSize(20);
                tv1.setTextColor(Color.WHITE);
                tv1.setBackgroundColor(Color.YELLOW);

        }


    });
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tv1.setText(charSequence);
                tv1.setTextSize(20);
                tv1.setTextColor(Color.GRAY);
                tv1.setBackgroundColor(Color.BLACK);

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tv1.setText(charSequence);
                tv1.setTextSize(20);
                tv1.setTextColor(Color.RED);
                tv1.setBackgroundColor(Color.WHITE);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                tv1.setText(editable);
                tv1.setTextSize(20);
                tv1.setTextColor(Color.BLACK);
                tv1.setBackgroundColor(Color.WHITE);

            }
        });
        String[] valores = {"valor1", "valor2", "valor3"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores);
        sp1.setAdapter(adaptador);
        cb1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                tv1.setText("Checkbox pulsado");
                tv1.setTextSize(20);
                if (cb1.isChecked()) {
                    tv1.setTextColor(Color.WHITE);
                    tv1.setBackgroundColor(Color.GREEN);
                    } else {
                    tv1.setTextColor(Color.BLACK);
                    tv1.setBackgroundColor(Color.WHITE);
                }

            }
        });

        }

}
