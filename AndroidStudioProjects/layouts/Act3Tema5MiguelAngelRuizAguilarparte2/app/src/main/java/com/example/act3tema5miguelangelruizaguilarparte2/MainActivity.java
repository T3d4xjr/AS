package com.example.act3tema5miguelangelruizaguilarparte2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextGmail;
    private EditText editTextPassword;
    private TextView textViewBienvenida;
    private ImageView imageViewPerfil;
    private Button btnAceptar;
    private Button btnCancelar;
    private Button buttonCerrarSesion;
    private TextView labelGmail;
    private TextView labelPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGmail = findViewById(R.id.editTextGmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewBienvenida = findViewById(R.id.textViewBienvenida);
        imageViewPerfil = findViewById(R.id.imageViewPerfil);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);
        buttonCerrarSesion = findViewById(R.id.buttonCerrarSesion);
        labelGmail = findViewById(R.id.labelGmail);
        labelPassword = findViewById(R.id.labelPassword);

        textViewBienvenida.setVisibility(View.GONE);
        imageViewPerfil.setVisibility(View.GONE);
        buttonCerrarSesion.setVisibility(View.GONE);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextGmail.setText("");
                editTextPassword.setText("");
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextGmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (!username.isEmpty() && !password.isEmpty()) {
                    mostrarBienvenida(username);
                } else {
                    Toast.makeText(MainActivity.this, "Por favor ingrese todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverALogin();
            }
        });
    }

    private void mostrarBienvenida(String username) {
        editTextGmail.setVisibility(View.GONE);
        editTextPassword.setVisibility(View.GONE);
        btnAceptar.setVisibility(View.GONE);
        btnCancelar.setVisibility(View.GONE);
        labelGmail.setVisibility(View.GONE);
        labelPassword.setVisibility(View.GONE);

        textViewBienvenida.setVisibility(View.VISIBLE);
        imageViewPerfil.setVisibility(View.VISIBLE);
        buttonCerrarSesion.setVisibility(View.VISIBLE);

        textViewBienvenida.setText("¡Bienvenido, "+"\n" + username + "!");
        imageViewPerfil.setImageResource(R.drawable.roca);
    }

    private void volverALogin() {
        editTextGmail.setVisibility(View.VISIBLE);
        editTextPassword.setVisibility(View.VISIBLE);
        btnAceptar.setVisibility(View.VISIBLE);
        btnCancelar.setVisibility(View.VISIBLE);
        labelGmail.setVisibility(View.VISIBLE);
        labelPassword.setVisibility(View.VISIBLE);

        textViewBienvenida.setVisibility(View.GONE);
        imageViewPerfil.setVisibility(View.GONE);
        buttonCerrarSesion.setVisibility(View.GONE);

        editTextGmail.setText("");
        editTextPassword.setText("");
    }
}





