package com.example.morewidgets

import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        createCheckbox()
        createRadioGroup()
        createSpinner()
       // createTimePicker()
       // createDatePicker()
        createProgressBar()





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun createCheckbox() {
        var checkBox: CheckBox = findViewById<CheckBox>(R.id.checkBox)
        checkBox.setOnCheckedChangeListener { _, bool ->

            if (bool) {
                Toast.makeText(this,"Test toats",Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun createRadioGroup() {
        val radioGroup: RadioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val cheese: RadioButton = findViewById<RadioButton>(R.id.cheeseradiobutton)
        val spice: RadioButton = findViewById<RadioButton>(R.id.spiceradiobutton)
        val onion: RadioButton = findViewById<RadioButton>(R.id.onionradiobutton)

        // Detecting selected radio button
        radioGroup.setOnCheckedChangeListener { group, i ->
            //group represents radiogruop itsel
            // i represents the resource ID of checked Radio Button

            when (i) {
                R.id.cheeseradiobutton -> {
                    Toast.makeText(this, "Cheese", Toast.LENGTH_SHORT).show()
                }

                R.id.spiceradiobutton -> {
                    Toast.makeText(this, "Spice", Toast.LENGTH_SHORT).show()
                }
                    R.id.onionradiobutton -> {
                        Toast.makeText(this, "Onion", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
    //spinner provides a drop down menu with items
    fun createSpinner() {
        //1 initilazie the spinner
        val spinner = findViewById<Spinner>(R.id.mySpinner)
        //2 We need to create data source
        //val languages = resources.getStringArray(R.array.languages)
        val languages1 = arrayOf("Linux","Windows","MacOS")

        //3 We need to link data source with view in 1
        //This is done via Adapter thats act as bridge between them

        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item,
            languages1)

        // set adapter to view
        spinner.adapter = adapter

        // Handling item selection is different
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                //p0 is parent
                //p1 is selecteditemview
                //p2 is postion
                //p4 is id

                val selectedItem = p0?.getItemAtPosition(p2).toString()
                Toast.makeText(this@MainActivity, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            // This MUST be inside the 'object' block
            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Leave this empty so the app doesn't crash
            }
        } // This closing bracket ends the 'object
    }


   /* fun createTimePicker() {
        val timepicker = findViewById<TimePicker>(R.id.mytimepicker)
        // Handle the changes in time 
        timepicker.setOnTimeChangedListener { picker, i, i1 ->

            //picker : view represents timepicker itself
            // i  = hour of the day => selected hour in 24h format
            //i1 = minute => selected minute

            // hh:mm
            var selectedTime = String.format("%02d:%02d",i,i1)
            Toast.makeText(applicationContext,"Your time : $selectedTime",Toast.LENGTH_SHORT).show()

        }
    }
*/
  /*  fun createDatePicker() {
        val datePicker = findViewById<DatePicker>(R.id.mydepicker)
        datePicker.setOnDateChangedListener { picker, i, i1, i2 ->
            // picker itself
            // i year
            // i1 month
            // i2

            Toast.makeText(
                applicationContext,
                "Year : $i Month : $i1 day: $i2",Toast.LENGTH_SHORT
            ).show()

        }

    } */

    fun createProgressBar() {
        val progressBar = findViewById<ProgressBar>(R.id.myprogressbar)
        val progress = 60
        progressBar.progress = progress
    }

}