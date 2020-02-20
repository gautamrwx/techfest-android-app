package com.gautam0x.techstorm220

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get NavigationView And Drawer Layout
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)

        // Set toolbar action
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.home_toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_menu_list_icon)
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(navigationView)
        }

        // Set Action For Navigation Menu Option Selection
        navigationView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener {
            when(it.itemId){

                R.id.nav_about_us -> Toast.makeText(applicationContext,"cam 1",Toast.LENGTH_SHORT).show()
                R.id.nav_result -> Toast.makeText(applicationContext,"cam 2",Toast.LENGTH_SHORT).show()
                R.id.nav_team -> Toast.makeText(applicationContext,"cam 3",Toast.LENGTH_SHORT).show()
                R.id.nav_developer -> Toast.makeText(applicationContext,"cam 4",Toast.LENGTH_SHORT).show()

                R.id.nav_website -> Toast.makeText(applicationContext,"cam 4",Toast.LENGTH_SHORT).show()
                R.id.nav_facebook -> Toast.makeText(applicationContext,"cam 4",Toast.LENGTH_SHORT).show()
                R.id.nav_youtube -> Toast.makeText(applicationContext,"cam 4",Toast.LENGTH_SHORT).show()
            }
            drawerLayout.closeDrawers()
            return@OnNavigationItemSelectedListener true
        })
    }
}
