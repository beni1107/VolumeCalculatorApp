package com.example.myapplication

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

//Adapter class acts as a bridge between data source and the GridView
class MyCustomAdapter(
     context: Context,
    private val gridItems: List<Shape>
) : ArrayAdapter<Shape>(context,0,gridItems){
    // context: required to access resources and layouts
    //0 the id of the resource file, 0 because we need to inflate
    //our custom layout and not predefined layout
    //griditems : list of type Shape that the adapter will adapt
    //display in the gridView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // it is responsible for returning the view that represents an item at a
        // specific position in a ListView, GridView or other similar componencts
        val holder: ViewHolder
        val itemView: View

        if (convertView == null) {

            val inflator = LayoutInflater.from(context)
            itemView = inflator.inflate(R.layout.grid_item_layout, parent, false)

            holder = ViewHolder()
            holder.imageView = itemView.findViewById(R.id.imageView)
            holder.textView = itemView.findViewById(R.id.textView)

            itemView.tag = holder

        } else {
            itemView = convertView
            holder = convertView.tag as ViewHolder
        }
        //Bindig data
        val currentItem = gridItems[position]
        holder.imageView.setImageResource(currentItem.shapeImg)
        holder.textView.text = currentItem.shapeName

        return itemView!!


    }


    // inner class
    private class ViewHolder {
        lateinit var imageView: ImageView
        lateinit var textView: TextView
    }


}