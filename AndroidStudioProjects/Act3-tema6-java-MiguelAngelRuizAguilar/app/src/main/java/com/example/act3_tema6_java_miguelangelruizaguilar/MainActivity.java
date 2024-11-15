package com.example.act3_tema6_java_miguelangelruizaguilar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.main);
        setSupportActionBar(toolbar);

        // Ajuste del padding para barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(toolbar, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Crear un submenú con el título "Días de la semana"
        SubMenu dias = menu.addSubMenu(Menu.NONE, Menu.NONE, Menu.NONE, "Días de la semana");

        // Agregar opciones al submenú para los días de la semana
        dias.add(Menu.NONE, 1, Menu.NONE, "Lunes");
        dias.add(Menu.NONE, 2, Menu.NONE, "Martes");
        dias.add(Menu.NONE, 3, Menu.NONE, "Miércoles");
        dias.add(Menu.NONE, 4, Menu.NONE, "Jueves");
        dias.add(Menu.NONE, 5, Menu.NONE, "Viernes");
        dias.add(Menu.NONE, 6, Menu.NONE, "Sábado");
        dias.add(Menu.NONE, 7, Menu.NONE, "Domingo");

        // Crear un submenú con el título "Meses del año"
        SubMenu meses = menu.addSubMenu(Menu.NONE, Menu.NONE, Menu.NONE, "Meses del año");
        meses.add(Menu.NONE, 101, Menu.NONE, "Enero");
        meses.add(Menu.NONE, 102, Menu.NONE, "Febrero");
        meses.add(Menu.NONE, 103, Menu.NONE, "Marzo");
        meses.add(Menu.NONE, 104, Menu.NONE, "Abril");
        meses.add(Menu.NONE, 105, Menu.NONE, "Mayo");
        meses.add(Menu.NONE, 106, Menu.NONE, "Junio");
        meses.add(Menu.NONE, 107, Menu.NONE, "Julio");
        meses.add(Menu.NONE, 108, Menu.NONE, "Agosto");
        meses.add(Menu.NONE, 109, Menu.NONE, "Septiembre");
        meses.add(Menu.NONE, 110, Menu.NONE, "Octubre");
        meses.add(Menu.NONE, 111, Menu.NONE, "Noviembre");
        meses.add(Menu.NONE, 112, Menu.NONE, "Diciembre");

        return true; // Indicar que el menú está listo para mostrarse
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Obtener el TextView del layout
        TextView texto1 = findViewById(R.id.textoMenu);

        // Verificar si el TextView existe
        if (texto1 == null) return super.onOptionsItemSelected(item);

        // Manejar clics en los días de la semana
        switch (item.getItemId()) {
            case 1:
                texto1.setText("Has pulsado: Lunes");
                return true;
            case 2:
                texto1.setText("Has pulsado: Martes");
                return true;
            case 3:
                texto1.setText("Has pulsado: Miércoles");
                return true;
            case 4:
                texto1.setText("Has pulsado: Jueves");
                return true;
            case 5:
                texto1.setText("Has pulsado: Viernes");
                return true;
            case 6:
                texto1.setText("Has pulsado: Sábado");
                return true;
            case 7:
                texto1.setText("Has pulsado: Domingo");
                return true;
            // Manejar clics en los meses del año
            case 101:
                texto1.setText("Has pulsado: Enero");
                return true;
            case 102:
                texto1.setText("Has pulsado: Febrero");
                return true;
            case 103:
                texto1.setText("Has pulsado: Marzo");
                return true;
            case 104:
                texto1.setText("Has pulsado: Abril");
                return true;
            case 105:
                texto1.setText("Has pulsado: Mayo");
                return true;
            case 106:
                texto1.setText("Has pulsado: Junio");
                return true;
            case 107:
                texto1.setText("Has pulsado: Julio");
                return true;
            case 108:
                texto1.setText("Has pulsado: Agosto");
                return true;
            case 109:
                texto1.setText("Has pulsado: Septiembre");
                return true;
            case 110:
                texto1.setText("Has pulsado: Octubre");
                return true;
            case 111:
                texto1.setText("Has pulsado: Noviembre");
                return true;
            case 112:
                texto1.setText("Has pulsado: Diciembre");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
