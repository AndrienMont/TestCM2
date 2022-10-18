package com.example.testcm2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.testcm2.R
import com.example.testcm2.adapter.CategoryAdapter.Companion.ICONS

class CategoryAdapter: BaseAdapter() {
    companion object {
        private val IDS = arrayOf(1,2)
        private val ICONS = arrayOf(R.drawable.ic_shopping,R.drawable.ic_category)
        private val TITLES = arrayOf(R.string.category_shopping,R.string.category_others)
        fun getIcon(p0:Int): Int{
            return ICONS.get(p0)
        }
    }

    override fun getCount(): Int {
        return IDS.size
    }

    override fun getItem(p0: Int): Any {
        return IDS.get(p0)
    }



    override fun getItemId(p0: Int): Long {
        return IDS.get(p0).toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        } else {
            view = convertView
        }
        view.findViewById<ImageView>(R.id.category_icon).setImageResource(ICONS[position])
        view.findViewById<TextView>(R.id.category_name).setText(TITLES[position])
        return view
    }
}