package com.example.projecthetwapen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
//import com.example.projecthetwapen.binding


class HomeActivity : AppCompatActivity() {
    private lateinit var layout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        val navView : BottomNavigationView = findViewById(R.id.menubar)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_subscription
            )
        )

//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//       var layout : ConstraintLayout = findViewById(R.id.HomeLayout)
//        layout.setOnTouchListener(object : OnSwipeTouchListener(this@HomeActivity){
//            override fun onSwipeLeft() {
//                super.onSwipeLeft()
//                Toast.makeText(this@HomeActivity,
//                    "Swipe left done",
//                    Toast.LENGTH_SHORT)
//                    .show()
//            }
//            override fun onSwipeRight() {
//                super.onSwipeRight()
//                Toast.makeText(
//                    this@HomeActivity,
//                    "Swipe Right gesture detected",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//            override fun onSwipeUp() {
//                super.onSwipeUp()
//                Toast.makeText(this@HomeActivity,
//                    "Swipe up gesture detected",
//                    Toast.LENGTH_SHORT)
//                    .show()
//            }
//            override fun onSwipeDown() {
//                super.onSwipeDown()
//                Toast.makeText(this@HomeActivity,
//                    "Swipe down gesture detected",
//                    Toast.LENGTH_SHORT)
//                    .show()
//            }
//        })
    }
}