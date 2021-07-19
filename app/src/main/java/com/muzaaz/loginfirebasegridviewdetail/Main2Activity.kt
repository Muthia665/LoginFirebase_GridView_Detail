package com.muzaaz.loginfirebasegridviewdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Main2Activity : AppCompatActivity() {

    private lateinit var rv: RecyclerView
    private var grid:ArrayList<Model> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rv = findViewById(R.id.recyclerView)
        grid.addAll(Data.listData)
        rv.layoutManager = GridLayoutManager(this@Main2Activity, 2)
        val adapterList = AdapterList(grid)
        rv.adapter = adapterList
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId
        )
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when (itemId) {
            R.id.menuAbout -> {
                val intent = Intent(this@Main2Activity, Dashboard::class.java)
                startActivity(intent)
            }
        }
    }

}
