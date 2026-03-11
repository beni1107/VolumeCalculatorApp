package com.example.constraitslayout

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var myButton: Button
    lateinit var myButotn2: Button
    lateinit var myButton3:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        myButton3 = findViewById(R.id.mainbtn3)
        myButton3.setOnClickListener {

            val implicitintent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.24.com")
            )
            startActivity(implicitintent)
        }





        myButton = findViewById(R.id.mainbtn)

        myButton.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("myname","Jack")
            startActivity(intent)
        }

        myButotn2 = findViewById(R.id.mainbtn2)
        myButotn2.setOnClickListener {
            var intent2 = Intent(this, SecondActivity::class.java)
                .putExtra("beni","Moooo")
            startActivity(intent2)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}