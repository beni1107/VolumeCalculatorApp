package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class PrismActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_prism)

        val baseArea: EditText = findViewById<EditText>(R.id.prismEditTextbaseArea)
        val baseParimeter: EditText = findViewById<EditText>(R.id.prismEditTextbaseParimeter)
        val height: EditText = findViewById<EditText>(R.id.prismEditTextbaseHeight)
        val result: TextView = findViewById<TextView>(R.id.prismResultTextView)
        val resultButton : Button = findViewById<Button>(R.id.prismcalculateButton)
        val backButton : Button = findViewById<Button>(R.id.prismBackButton)

        resultButton.setOnClickListener {
            val ba = baseArea.text.toString().toIntOrNull() ?: 0
            val bp = baseParimeter.text.toString().toIntOrNull() ?: 0
            val h = height.text.toString().toIntOrNull() ?: 0

            val surface = 2 * ba + bp * h

            result.text = surface.toString()
        }
        backButton.setOnClickListener {
            this.finish()
        }
    }
}