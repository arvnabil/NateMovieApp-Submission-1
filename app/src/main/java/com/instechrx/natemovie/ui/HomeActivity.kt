package com.instechrx.natemovie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.instechrx.natemovie.R
import kotlin.system.exitProcess

class HomeActivity : AppCompatActivity() {
    private var time: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        AppBarConfiguration(
            setOf(
                R.id.navigation_movies, R.id.navigation_tvshow, R.id.navigation_profile
            )
        )

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(navView, navController)
    }

    override fun onBackPressed() {
        val twoSecond = 2000
        val strExit: String = getString(R.string.exit)
        if (time.plus(twoSecond) > System.currentTimeMillis()) {
            super.onBackPressed()
            moveTaskToBack(true)
            finish()
            exitProcess(0)
        } else {
            Toast.makeText(this, strExit, Toast.LENGTH_SHORT)
                .show()
        }
        time = System.currentTimeMillis()
    }
}