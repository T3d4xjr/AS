package com.example.act4tema6parte2miguelangelruizaguilar;

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
    private String[] opciones =new String[] {"Opción A", "Opción B", "Opción C", "Opción D", "Opción E"};
    private String textoSeleccionadoString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listView);
        textoSeleccionado = findViewById(R.id.textoSeleccionado);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opciones);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(opciones[info.position]);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String selectedOption = opciones[info.position];

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

        textoSeleccionado.setText(textoSeleccionadoString);
        return true;
    }
}
