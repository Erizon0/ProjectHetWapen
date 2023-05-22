package com.example.projecthetwapen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projecthetwapen.DATA.APIController
import com.example.projecthetwapen.DATA.API_Call
import com.example.projecthetwapen.DATA.Beer

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val apiC = APIController.getInstance(this)
        apiC.getBeer(object : API_Call{
            override fun onSuccess(bList: ArrayList<Beer>) {
                intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

        })

//        Handler().postDelayed({
//            val intent = Intent(this@MainActivity, HomeActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, 5000)

    }
}