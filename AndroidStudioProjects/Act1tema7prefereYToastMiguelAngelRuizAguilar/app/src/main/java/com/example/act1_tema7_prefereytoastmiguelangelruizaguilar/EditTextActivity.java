package com.example.act1_tema7_prefereytoastmiguelangelruizaguilar;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);

        EditText editText = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView);

        editText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                String texto = editText.getText().toString();

                textView.setText(texto);


                Toast.makeText(EditTextActivity.this, "Texto actualizado: " + texto, Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });


        Button mainMenuButton = findViewById(R.id.mainMenuButton);
        mainMenuButton.setOnClickListener(v -> {

            Intent intent = new Intent(EditTextActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
