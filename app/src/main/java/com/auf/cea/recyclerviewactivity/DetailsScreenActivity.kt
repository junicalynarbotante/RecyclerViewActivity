package com.auf.cea.recyclerviewactivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.auf.cea.recyclerviewactivity.databinding.ActivityDetailsScreenBinding
import com.auf.cea.recyclerviewactivity.databinding.ActivityMainBinding
import com.auf.cea.recyclerviewactivity.databinding.ContentMainBinding


class DetailsScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookName = intent.getSerializableExtra("bookName")
        val bookDescription = intent.getSerializableExtra("bookDescription")
        val bookAuthor = intent.getSerializableExtra("bookAuthor")
        val bookPublished = intent.getSerializableExtra("bookPublished")
        val url = intent.getSerializableExtra("url")

        supportActionBar?.title = bookName.toString()
        binding.txtName.text = bookName.toString()
        binding.txtAuthorDate.text = String.format("by %s (%s)", bookAuthor.toString(), bookPublished.toString())
        binding.txtFullDes.text = bookDescription.toString()

        binding.btnShopNow.setOnClickListener{
            val urllink = Intent(Intent.ACTION_VIEW, Uri.parse(url.toString()))
            startActivity(urllink)
        }
    }
}