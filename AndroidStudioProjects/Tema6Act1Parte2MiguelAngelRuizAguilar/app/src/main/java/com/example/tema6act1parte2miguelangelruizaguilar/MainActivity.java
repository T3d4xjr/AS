    package com.example.tema6act1parte2miguelangelruizaguilar;



    import android.os.Bundle;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.GridView;
    import android.widget.TextView;
    import androidx.appcompat.app.AppCompatActivity;


    public class MainActivity extends AppCompatActivity {


        GridView listado;
        TextView textSelecciona;
        final String[] datos = new String[]{"Argentina", "Peru", "España", "Francia", "Alemania", "Italia", "Canada", "Venezuela", "Mexico", "Chile"};
        final int[] colores = {
                0xFFFFCDD2, 0xFFF8BBD0, 0xFFE1BEE7, 0xFFD1C4E9,
                0xFFC5CAE9, 0xFFBBDEFB, 0xFFB3E5FC, 0xFFB2EBF2,
                0xFFB2DFDB, 0xFFC8E6C9
        };


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            listado = findViewById(R.id.listado);
            textSelecciona = findViewById(R.id.textSelecciona);


            // Adaptador personalizado en línea
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    view.setBackgroundColor(colores[position % colores.length]); // Asigna un color diferente según la posición
                    return view;
                }
            };


            listado.setAdapter(adaptador);


            listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
                    String elemento = (String) parent.getAdapter().getItem(posicion);
                    textSelecciona.setText("Seleccionaste: " + elemento);
                }
            });
        }
    }
