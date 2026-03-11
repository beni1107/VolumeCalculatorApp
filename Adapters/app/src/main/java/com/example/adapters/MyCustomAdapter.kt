package com.example.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyCustomAdapter(
    private val context: Context,
    private val items: List<String>
) : BaseAdapter() {
    override fun getCount(): Int = items.size
        //returns the number of items in the data set

    override fun getItem(p0: Int): Any? = items.getOrNull(p0)
        // returns the data on the p0 index within data set

    override fun getItemId(p0: Int): Long = p0.toLong()
        //returns the unique id for the item at the specific position



    override fun getView(position: Int, convertView: View?,
        parent: ViewGroup?
    ): View? {
       //Returns view that displays the data at the specified position in the
        // data set
        //convertview : recycledView that can be reused to optimize performance

        val inflator = context.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View
        if(convertView == null ) {
            //inflate a new view using layout inflator
            view = inflator.inflate(R.layout.my_custom_layout, parent, false)
        }else {
            //if convertView is not null REUSE IT
            view = convertView
        }

        //2 bind data to the view

        val item = getItem(position) as String
        val titleTextView =  view.findViewById<TextView>(R.id.textViewCustom)

        titleTextView.text = item
        return view



    }
}