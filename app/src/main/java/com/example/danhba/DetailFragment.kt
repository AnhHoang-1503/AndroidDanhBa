package com.example.danhba

import android.content.ClipData.Item
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson

class DetailFragment : Fragment() {

    lateinit var imageThumb: ImageView
    lateinit var name: TextView
    lateinit var phone: TextView
    lateinit var email: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_infor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageThumb = view.findViewById(R.id.image_thumb)
        name = view.findViewById(R.id.name)
        phone = view.findViewById(R.id.phone)
        email = view.findViewById(R.id.email)

        val itemJson = arguments?.getString("ITEM_MODEL")
        itemJson?.let {
            val item = Gson().fromJson(it, ItemModel::class.java)
            UpdateContent(item)
        }
    }

    fun UpdateContent(item: ItemModel) {
        name.text = item.name
        phone.text = item.phone
        email.text = item.email
        imageThumb.setImageResource(item.imageThumb)
    }
}