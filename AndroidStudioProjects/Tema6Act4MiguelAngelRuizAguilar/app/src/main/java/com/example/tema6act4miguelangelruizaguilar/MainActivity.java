package com.example.tema6act4miguelangelruizaguilar;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView textoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincula los TextViews
        textView = findViewById(R.id.textView);
        textoSeleccionado = findViewById(R.id.textoSeleccionado);

        // Registra el TextView para el menú contextual
        registerForContextMenu(textView);
    }

    // Este método se llama cuando el usuario hace una pulsación larga sobre el TextView
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Verifica que el menú se haya solicitado desde el TextVie
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu); // Carga el menú contextual

    }

    // Este método maneja la selección del ítem en el menú contextual
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String selectedText = "";
        switch (item.getItemId()) {
            case R.id.option_a:
                selectedText = "Seleccionaste Opción A";
                break;
            case R.id.option_b:
                selectedText = "Seleccionaste Opción B";
                break;
            case R.id.option_c:
                selectedText = "Seleccionaste Opción C";
                break;
            case R.id.sub_option_1:
                selectedText = "Seleccionaste Subopción 1 de Opción B";
                break;
            case R.id.sub_option_2:
                selectedText = "Seleccionaste Subopción 2 de Opción B";
                break;
            default:
                return super.onContextItemSelected(item);
        }

        // Muestra la opción seleccionada en el segundo TextView
        textoSeleccionado.setText(selectedText);
        return true;
    }
}
