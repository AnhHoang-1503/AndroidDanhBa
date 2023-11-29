package com.example.danhba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemAdapter (val items: ArrayList<ItemModel>): BaseAdapter() {
    override fun getCount(): Int = items.size

    override fun getItem(p0: Int): Any =items[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_view_item, parent, false)

            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = itemView.tag as ViewHolder
        }

        viewHolder.imageThumb.setImageResource(items[position].imageThumb)
        viewHolder.textCaption.text = items[position].name

        return itemView
    }

    class ViewHolder(itemView: View) {
        val imageThumb: ImageView
        val textCaption: TextView
        init {
            textCaption = itemView.findViewById(R.id.text_caption)
            imageThumb = itemView.findViewById(R.id.image_thumb)
        }
    }
}