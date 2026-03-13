package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CubeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cube)

        val input: EditText = findViewById<EditText>(R.id.cubeeditText)
        val result: TextView = findViewById<TextView>(R.id.cubetextView2)
        val buttonCalculate: Button = findViewById<Button>(R.id.cubecalculateButton)
        val backButton: Button = findViewById<Button>(R.id.cubebackbutton)

        buttonCalculate.setOnClickListener {
            var a = Integer.parseInt(input.text.toString())
            result.text = "Volume ${(a*a*a)} mˇ3 "
        }

        backButton.setOnClickListener {
            this.finish()
        }
        }

    }
