package com.example.act4tema6menuscontextualejercxmlmiguelangelruizaguilar;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textoSeleccionado = findViewById(R.id.textoSeleccionado);

        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

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
        textoSeleccionado.setText(selectedText);
        return true;
    }
}
