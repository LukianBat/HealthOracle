package com.memebattle.template.features

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.template.R

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        navController = Navigation.findNavController(this, R.id.nav_host_main)

    }

}
