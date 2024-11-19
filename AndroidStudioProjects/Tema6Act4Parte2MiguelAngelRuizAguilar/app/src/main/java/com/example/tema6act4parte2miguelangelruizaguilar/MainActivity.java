package com.example.tema6act4parte2miguelangelruizaguilar;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textoSeleccionado;
    private String[] opciones = {"Opción A", "Opción B", "Opción C", "Opción D", "Opción E"};
    private String textoSeleccionadoString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincula el ListView y el TextView
        listView = findViewById(R.id.listView);
        textoSeleccionado = findViewById(R.id.textoSeleccionado);

        // Crea un adaptador para la lista con las opciones
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opciones);
        listView.setAdapter(adapter);

        // Registra el ListView para el menú contextual
        registerForContextMenu(listView);
    }

    // Este método se llama cuando el usuario hace una pulsación larga sobre un ítem de la lista
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Infla el menú contextual único
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        // Obtén la posición del ítem seleccionado y establece un título personalizado
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(opciones[info.position]); // Personaliza el título del menú contextual
    }

    // Este método maneja la selección de un ítem del menú contextual
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Obtén la posición del ítem de la lista que se seleccionó
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String selectedOption = opciones[info.position];

        // Comprobamos qué opción del menú contextual fue seleccionada
        switch (item.getItemId()) {
            case R.id.action_option_1:
                textoSeleccionadoString = "Seleccionaste " + selectedOption + " - Opción 1";
                break;
            case R.id.action_option_2:
                textoSeleccionadoString = "Seleccionaste " + selectedOption + " - Opción 2";
                break;
            default:
                return super.onContextItemSelected(item);
        }

        // Muestra la opción seleccionada en el segundo TextView
        textoSeleccionado.setText(textoSeleccionadoString);
        return true;
    }
}
