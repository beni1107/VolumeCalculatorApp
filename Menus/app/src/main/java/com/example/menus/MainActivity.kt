package com.example.menus

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.my_own_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.new_note) {
            Toast.makeText(this, "New note Selected",Toast.LENGTH_SHORT).show()
        }

        if (item.itemId == R.id.save_note) {
            Toast.makeText(this,"Save note Selected", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)
                .putExtra("Beni","This is the SAve note Text")
            startActivity(intent)

        }
        return true
    }
}