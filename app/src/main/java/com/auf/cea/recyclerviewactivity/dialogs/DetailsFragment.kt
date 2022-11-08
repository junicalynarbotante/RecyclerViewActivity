package com.auf.cea.recyclerviewactivity.dialogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.auf.cea.recyclerviewactivity.R


class DetailsFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var DetailsFragment : View = inflater.inflate(R.layout.fragment_details,container,false)
        var closebutton = DetailsFragment.findViewById<Button>(R.id.btn_close)
        var name = DetailsFragment.findViewById<TextView>(R.id.txt_name)
        var dateAuthor = DetailsFragment.findViewById<TextView>(R.id.txt_author_date)
        var description = DetailsFragment.findViewById<TextView>(R.id.txt_full_des)

        if(arguments != null){
            name.text = arguments?.getString("bookName")
            dateAuthor.text = arguments?.getString("bookAuthor")+" Published: "+arguments?.getString("bookdatePublish")
            description.text = arguments?.getString("bookDescription")
        }


        closebutton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v:View){
                dismiss()
            }
        })
        return DetailsFragment
    }

}