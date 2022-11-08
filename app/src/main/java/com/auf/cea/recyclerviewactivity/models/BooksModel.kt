package com.auf.cea.recyclerviewactivity.models

import java.io.Serializable


data class BooksModel(
    var name: String,
    var author: String,
    var shortDescription: String,
    var description: String,
    var datePublished: String,
    var url : String
) : Serializable
