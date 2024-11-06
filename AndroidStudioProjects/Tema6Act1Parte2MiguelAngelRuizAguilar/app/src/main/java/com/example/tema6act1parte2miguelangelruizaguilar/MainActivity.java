    package com.example.tema6act1parte2miguelangelruizaguilar;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.GridView;
    import android.widget.TextView;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    import java.util.Arrays;

    public class MainActivity extends AppCompatActivity {

        GridView listado;
        TextView textSelecciona;
        final String[] datos = new String[]{"Argentina", "Peru", "España", "Francia", "Alemania", "Italia", "Canada", "Venezuela", "Mexico", "Chile"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Inflar el diseño primero
            setContentView(R.layout.activity_main);

            // Inicializar el ListView después de setContentView
            listado = findViewById(R.id.lista);
            textSelecciona=findViewById(R.id.textSelecciona);

            String[] datosLimitados = Arrays.copyOfRange(datos, 0, Math.min(10, datos.length));

            ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, datosLimitados);
            listado.setAdapter(adaptador);


            ViewCompat.setOnApplyWindowInsetsListener(listado, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
                    String elemento =(String) parent.getAdapter().getItem(posicion);
                    textSelecciona.setText("Seleccionaste: " + elemento);
                }
            });

        }
    }
