package com.example.projecthetwapen.DATA

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray


class APIController (context: Context) {
    companion object {
        @Volatile
        private var instance: APIController? = null
        fun getInstance(context: Context): APIController {
            if (instance == null) {
                instance = APIController(context)
            }
            return instance as APIController
        }
    }

    var url: String = "https://hetwapen.projects.adainforma.tk/api/v1/beer"
    var queue: RequestQueue = Volley.newRequestQueue(context)
    val gson : Gson = Gson()
    var beerList : ArrayList<Beer> = arrayListOf()


    fun getBeer(param: API_Call) {
        if (beerList.isEmpty()) {
            val stringRequest = StringRequest(
                Request.Method.POST,
                url,
                {response->
                    responseToArray(response, param)

                }, {error->
                    Log.d("API ERROR", error.toString())
                })
            queue.add(stringRequest)

        } else {
            //TODO directe call naar lijst
            Log.d("API", "Data kept")
        }

    }

    private fun responseToArray(response: String, call: API_Call) {
        val jObj = JSONArray(response)
        val beerArray = object : TypeToken<Array<Beer>>(){}.type

        val temp : Array<Beer> = gson.fromJson(jObj.toString(), beerArray)
        this.beerList.addAll(temp)
        call.onSuccess(this.beerList)
        Log.d("API", this.beerList.toString())
    }


    fun getBeer() : ArrayList<Beer>{
        Log.d("API", "Returning beer list")

        return this.beerList
    }

}