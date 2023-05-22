package com.example.projecthetwapen.DATA

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray


class APIController (var context: Context) : API_Call {

    var url: String = "https://hetwapen.projects.adainforma.tk/api/v1/beer"
    var queue: RequestQueue = Volley.newRequestQueue(context)
    val gson : Gson = Gson()
    var beerList : ArrayList<Beer> = arrayListOf<Beer>()

    fun getData(){
        if (beers.isEmpty()) {
            val stringRequest = StringRequest(
                Request.Method.POST,
                url,
                {response->
                    responseToArray(response)
                }, {error->
                    Toast.makeText(context, "Geen reactie", Toast.LENGTH_SHORT)
                    Log.d("API ERROR", error.toString())
                })
            queue.add(stringRequest)
        } else {
            //TODO directe call naar lijst
            Log.d("API", "Data kept")
        }
    }

    private fun responseToArray(response: String) {
        val jObj = JSONArray(response)
        val beerArray = object : TypeToken<Array<Beer>>(){}.type

        val temp : Array<Beer> = gson.fromJson(jObj.toString(), beerArray)
        this.beers.addAll(temp)
        Log.d("API", this.beerList.toString())
    }

    override val beers: ArrayList<Beer>
        get() = this.beerList


}