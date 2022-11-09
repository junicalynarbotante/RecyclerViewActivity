package com.auf.cea.recyclerviewactivity.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat.getDrawable
import androidx.core.content.res.ResourcesCompat.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewactivity.DetailsScreenActivity
import com.auf.cea.recyclerviewactivity.R
import com.auf.cea.recyclerviewactivity.databinding.ContentMainBinding
import com.auf.cea.recyclerviewactivity.dialogs.DetailsFragment
import com.auf.cea.recyclerviewactivity.models.BooksModel

class MainAdapter(private var bookList: ArrayList<BooksModel>, private var context: Context) : RecyclerView.Adapter<MainAdapter.SimpleRVViewHolder>() {

    lateinit var imageId : Array<Int>

    inner class SimpleRVViewHolder(val binding: ContentMainBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(binding: ContentMainBinding){

            binding.btnShopNow.setOnClickListener {
                val bookData = bookList[adapterPosition]
                val url = Intent(Intent.ACTION_VIEW, Uri.parse(bookData.url))
                context.startActivity(url)
            }

            binding.btnReadFullDes.setOnClickListener{
                val bookData = bookList[adapterPosition]
                val intent  = Intent(context,DetailsScreenActivity::class.java)
                intent.putExtra("bookName",bookData.name)
                intent.putExtra("bookAuthor",bookData.author)
                intent.putExtra("bookDescription",bookData.description)
                intent.putExtra("bookPublished",bookData.datePublished)
                intent.putExtra("url",bookData.url)
                context.startActivity(intent)
            }
            binding.btnViewMore.setOnClickListener{
                val bookData = bookList[adapterPosition]
                val fragmentmanager = (context as AppCompatActivity).supportFragmentManager
                val detailsfragment = DetailsFragment()
                val bundle = Bundle()
                bundle.putString("bookName",bookData.name)
                bundle.putString("bookAuthor",bookData.author)
                bundle.putString("bookdatePublish",bookData.datePublished)
                bundle.putString("bookDescription",bookData.description)
                detailsfragment.arguments = bundle
                detailsfragment.show(fragmentmanager,"Details Fragment")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleRVViewHolder {
        val binding = ContentMainBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SimpleRVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SimpleRVViewHolder, position: Int) {


        with(holder){
            holder.bind(holder.binding)
            with(bookList[position]){
                binding.txtName.text = this.name
                binding.txtAuthorDate.text = String.format("by %s (%s)",this.author,this.datePublished)
                binding.txtShortDes.text = this.shortDescription
                binding.imgbook.setImageResource(this.imageID)
            }
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

}