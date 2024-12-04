package com.example.prueba4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView ls;
    GridView gs;

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
        ls = findViewById(R.id.ls);
        gs = findViewById(R.id.gs);
        String[] datos ={"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez"};
        String[] datos2 ={"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez"};
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,datos);
        ls.setAdapter(adapter);
       ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String item = adapterView.getItemAtPosition(i).toString();
               Toast.makeText(MainActivity.this,"Has pulsado "+item,Toast.LENGTH_SHORT).show();

           }
       });


    }

}
