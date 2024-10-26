package com.example.act1tema5miguelangelruizaguilar

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Crear un TextView desde Kotlin
        val textView2 = TextView(this)
        textView2.text = "Texto construido desde Java\nTamaño 20dp, Italic y color Blue"
        textView2.textSize = 20f
        textView2.setTypeface(null, Typeface.ITALIC)
        textView2.setTextColor(Color.BLUE)

        // Establecer los parámetros de diseño para centrar el TextView
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = Gravity.CENTER // Centrar el TextView dentro del LinearLayout
        }

        // Asignar los parámetros al TextView
        textView2.layoutParams = layoutParams

        // Añadir el TextView al layout
        val layout = findViewById<LinearLayout>(R.id.main)
        layout.addView(textView2)
    }
}