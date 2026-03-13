package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // List of shapes
        val gridView : GridView = findViewById(R.id.gridView)
        val listOfShapes = listOf<Shape>(
            Shape(R.drawable.sphere,"Sphere"),
            Shape(R.drawable.cube,"Cube"),
            Shape(R.drawable.prism,"Prism"),
            Shape(R.drawable.cylinder,"Cylinder"),
        )
        // The adapter - linking adapter to gridview
        val customAdapter = MyCustomAdapter(this,listOfShapes)
        gridView.adapter = customAdapter

        // set on click listener in
        gridView.setOnItemClickListener { _, _, position, id ->

            val clickedItem = customAdapter.getItem(position)

            if (clickedItem?.shapeName == "Sphere") {
                startActivity(Intent(this, SphereActivity::class.java))
            }
             if (clickedItem?.shapeName == "Cube") {
                startActivity(Intent(this, CubeActivity::class.java))
            }
            if (clickedItem?.shapeName == "Prism") {
                startActivity(Intent(this,PrismActivity::class.java))
            }
            if(clickedItem?.shapeName == "Cylinder") {
                startActivity(Intent(this, CylinderActivity::class.java))
            }
        }

        }
    }
