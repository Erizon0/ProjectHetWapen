package com.example.projecthetwapen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projecthetwapen.DATA.APIController

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apiCall = APIController(this)
        apiCall.getData()

        setContentView(R.layout.activity_home)
    }
}