package com.example.adapters

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 1 initilazi Listview
        val myListView: ListView = findViewById<ListView>(R.id.myList)
        // 2 Data source
        val operatingSystems = arrayListOf<String>("Windows","Linux","MacOs","Android","iOS")

        // 3 Adapter
        //ListView doesnt hold the data it displays it relays on adapter and its data source
        //Adapters are responsible for creating views for each item in ListView
     /*   val myAdapter = ArrayAdapter(
            this, //contex
            //android.R.layout.simple_list_item_1, //Template Layout
            R.layout.my_custom_layout,
            operatingSystems //Data source
        )*/

        val customAdaptor = MyCustomAdapter(this,operatingSystems)
        //4 set the Adapter to ListView
       // myListView.adapter = myAdapter
        myListView.adapter = customAdaptor
    }
}