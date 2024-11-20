package com.example.act1_tema7_miguelangelruizaguilar;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        // Configurar título en el Toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Activity con EditText");
        }

        // Configurar el EditText
        EditText editText = findViewById(R.id.editText);
        editText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                String texto = editText.getText().toString();
                Toast.makeText(EditTextActivity.this, texto, Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
    }
}