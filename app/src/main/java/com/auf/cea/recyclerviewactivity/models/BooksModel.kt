package com.auf.cea.recyclerviewactivity.models

import android.graphics.drawable.Drawable
import android.media.Image
import java.io.Serializable


data class BooksModel(
    var name: String,
    var author: String,
    var shortDescription: String,
    var description: String,
    var datePublished: String,
    var url : String,
    var imageID : Int
)
