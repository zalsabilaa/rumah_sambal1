package com.example.rumahsambal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class listviewadapter(var mContext: Context, var resources: Int, var items:List<listview>): ArrayAdapter<listview>(mContext, resources, items) {
    override fun  getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mContext)
        val view:View = layoutInflater.inflate(resources,  null)
        val imageView: ImageView = view.findViewById(R.id.item1)
        val headline: TextView = view.findViewById(R.id.headline1)
        val subline: TextView = view.findViewById(R.id.subhead1)

        var mItem:listview = items[position]
        imageView.setImageDrawable(mContext.resources.getDrawable(mItem.item1))
        headline.text = mItem.headline1
        subline.text = mItem.subhead1

        return view

    }
}