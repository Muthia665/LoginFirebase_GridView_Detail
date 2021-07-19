package com.muzaaz.loginfirebasegridviewdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra("name")
        val detail = intent.getStringExtra("detail")
        val photo = intent.getIntExtra("photo", 0)

        val tvname : TextView = findViewById(R.id.detail_nama)
        val tvisi : TextView = findViewById(R.id.detail_isi)
        val imgphoto : ImageView = findViewById(R.id.detail_photo)

        tvname.text = name
        tvisi.text = detail
        Glide.with(this).load(photo).into(imgphoto)

    }
}
