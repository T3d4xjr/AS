package com.example.actcuadrotexto;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.boton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listado().show();
            }
        });

    }
    public AlertDialog listado(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] dias ={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        builder.setTitle("Titulo")
                
                .setItems(dias, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(getApplication(),"Tocado "+dias[which],Toast.LENGTH_LONG).show();
                    }
                });

        return builder.create();
    }
}
    /*
    public AlertDialog dialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Titulo")
                .setMessage("Toca un de los elementos")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(getApplication(),"Tocado Boton aceptar",Toast.LENGTH_LONG).show();
                    }
                })
                .setNeutralButton("Neutro", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(getApplication(),"Tocado Boton neutro",Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(getApplication(),"Tocado Boton cancelar",Toast.LENGTH_LONG).show();
                    }
                });
        return builder.create();
    }
}
*/
