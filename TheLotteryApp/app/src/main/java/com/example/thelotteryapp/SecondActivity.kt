package com.example.thelotteryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        var resultText: TextView = findViewById<TextView>(R.id.resultText)
        val resultButton: Button = findViewById<Button>(R.id.resultButton)
        val backButton : Button = findViewById<Button>(R.id.backButton)

        var random = generateRandomNumber(6).joinToString(" ")
        resultText.text = random

        val username = getUsername()

        resultButton.setOnClickListener {
            shareUsername(username,random)
        }

        backButton.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun generateRandomNumber(count : Int):List<String> {
        var randomNumers = List(count){
            (1..42).random().toString()
        }
        return randomNumers
    }

    fun getUsername():String {
        var bundle:Bundle? = intent.extras

        return bundle?.getString("username").toString() ?: "No user"
    }

    fun shareUsername(username: String, genNumbers:String) {
        var i = Intent(Intent.ACTION_SEND)
        i.putExtra(Intent.EXTRA_SUBJECT, "$username geneterated theese numbers")
        i.putExtra(Intent.EXTRA_TEXT, "The lottery numbers are $genNumbers")
        i.type="text/plain"
        startActivity(i)
    }
}