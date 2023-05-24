package com.example.projecthetwapen.UI.detail_beer

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.projecthetwapen.DATA.APIController
import com.example.projecthetwapen.R
import java.io.BufferedInputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


class DetailPaginaFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_pagina, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val i = arguments?.getInt("selected")
        val apiC = APIController.getInstance(this.requireContext())
        //TODO null pointer exception oplossen
        val selectedBeer = apiC.getBeer()[i!!]

        val beerimage = view.findViewById<ImageView>(R.id.backgroundImage)
        val beerFrontImage = view.findViewById<ImageView>(R.id.frontImage)

        LoadImageTask(beerimage).execute(selectedBeer.image)
        LoadImageTask(beerFrontImage).execute(selectedBeer.image)
    }

    private inner class LoadImageTask(private val imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {
        override fun doInBackground(vararg params: String): Bitmap? {
            val imageUrl = params[0]
            var connection: HttpURLConnection? = null
            var inputStream: BufferedInputStream? = null

            try {
                val url = URL(imageUrl)
                connection = url.openConnection() as HttpURLConnection
                connection.connect()

                inputStream = BufferedInputStream(connection.inputStream)
                return BitmapFactory.decodeStream(inputStream)
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()
                try {
                    inputStream?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            return null
        }

        override fun onPostExecute(result: Bitmap?) {
            if (result != null) {
                imageView.setImageBitmap(result)
            } else {
                // Set a placeholder image or handle error case
                imageView.setImageResource(R.drawable.placeholder_image)
            }
        }
    }
}