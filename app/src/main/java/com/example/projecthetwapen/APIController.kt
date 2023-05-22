package com.example.projecthetwapen

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson


class APIController (var context: Context) {
    // stap 1 url naar de API in een var string gezet
    //stap 2 inladen volley library file -> project structure -> dependencies -> + -> library dependecies -> typ in : com.android.volley -> search
    //stap 3 RequestQueue kan een verzoek indienen bij de API
    // stap 4 maak functie aan

    var url: String = "https://hetwapen.projects.adainforma.tk/api/v1"
    var queue: RequestQueue = Volley.newRequestQueue(context)
    val gson : Gson = Gson()

    fun getData(){
        //stap 5
        val stringRequest : StringRequest = StringRequest(
            Request.Method.GET,
            url,
            {response->
                println(response.toString())
            }, {error->
                Toast.makeText(context, "Geen reactie", Toast.LENGTH_SHORT)
            })
        queue.add(stringRequest)
    }

}