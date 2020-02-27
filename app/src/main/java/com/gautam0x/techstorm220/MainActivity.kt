package com.gautam0x.techstorm220

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import maes.tech.intentanim.CustomIntent.customType

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
                R.id.nav_team -> startActivity(Intent(this,TeamProfilesActivity::class.java))

                R.id.nav_website -> Toast.makeText(applicationContext,"cam 4",Toast.LENGTH_SHORT).show()
                R.id.nav_facebook -> Toast.makeText(applicationContext,"cam 4",Toast.LENGTH_SHORT).show()
                R.id.nav_youtube -> Toast.makeText(applicationContext,"cam 4",Toast.LENGTH_SHORT).show()
            }
            drawerLayout.closeDrawers()
            return@OnNavigationItemSelectedListener true
        })



        val eventTypes = ArrayList<EventTypes>()
        eventTypes.add(EventTypes("Rovers","event_data_rovers.json",R.drawable.robos))
        eventTypes.add(EventTypes("Brain Teaser","event_data_brain_teaser.json",R.drawable.cube))
        eventTypes.add(EventTypes("Gaming","event_data_gaming.json",R.drawable.games))
        eventTypes.add(EventTypes("Creativity","event_data_creativity.json",R.drawable.vcamera))

        viewPager.adapter = EventTypesAdapter(eventTypes,this)

  }

    fun startEventCardSwipeActivity(jsonFileName:String)
    {
        val intent = Intent(this,EventCardSwipeActivity::class.java)
        intent.putExtra("jsonFileName",jsonFileName)
        startActivity(intent)

        // intent animation
        customType(this,"fadein-to-fadeout")
    }
}