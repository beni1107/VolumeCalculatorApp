package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SphereActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spehere)

        val enteredText: EditText = findViewById<EditText>(R.id.editText)
        val result: TextView = findViewById<TextView>(R.id.textView3)
        val button: Button = findViewById<Button>(R.id.spehereButton)
        val backbutton:Button = findViewById<Button>(R.id.backbutton)

        button.setOnClickListener {
             var radious = enteredText.text.toString()
             var r = Integer.parseInt(radious)

            var volume = (4/3) * 3.14159 * r*r*r
            result.text ="V $volume mˇ3"
        }

        backbutton.setOnClickListener {
            this.finish()
        }

    }
}