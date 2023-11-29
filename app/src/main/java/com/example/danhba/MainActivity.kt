package com.example.danhba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val items = arrayListOf<ItemModel>()
        repeat(50) { index ->
            items.add(
                ItemModel(
                    imageThumb = R.drawable.thumb10,
                    phone = "123456789",
                    name = "Người dùng ${index + 1}",
                    email = "email Người dùng ${index + 1}"
                )
            )
        }

        listView = findViewById<ListView>(R.id.list_view)

        val adapter = ItemAdapter(items)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, id ->
            val item = adapter.getItem(position) as ItemModel
            openDetailFragment(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.navigation_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add -> {
                //
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun openDetailFragment(item: ItemModel) {
        val fragment = DetailFragment()
        val bundle = Bundle().apply {
            putString("ITEM_MODEL", Gson().toJson(item))
        }
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .addToBackStack(null)
            .commit()

        listView.visibility = View.GONE
    }

    override fun onBackPressed() {
        super.onBackPressed()
        listView.visibility = View.VISIBLE
    }
}