package com.example.brokentabs

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setupWithNavController(findNavController(R.id.nav_host_fragment))

        navigation.setOnNavigationItemSelectedListener {item ->
            NavigationUI.onNavDestinationSelected(item, findNavController(R.id.nav_host_fragment))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showOther(
    ) {
        findNavController(R.id.nav_host_fragment).navigate(R.id.otherFragment)
    }
}
