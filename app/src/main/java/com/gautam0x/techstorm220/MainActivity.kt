package com.gautam0x.techstorm220

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

                R.id.nav_about_us -> startActivity(Intent(this,AboutUsActivity::class.java))
                R.id.nav_identity -> startActivity(Intent(this,RegistrationInfoActivity::class.java))
                R.id.nav_team -> startActivity(Intent(this,TeamProfilesActivity::class.java))
                R.id.nav_website -> Toast.makeText(applicationContext,"Result will Link to fest website",Toast.LENGTH_SHORT).show()


                R.id.nav_website -> Toast.makeText(applicationContext,"cam 4",Toast.LENGTH_SHORT).show()
                R.id.nav_facebook -> Toast.makeText(applicationContext,"cam 4",Toast.LENGTH_SHORT).show()
                R.id.nav_youtube -> Toast.makeText(applicationContext,"cam 4",Toast.LENGTH_SHORT).show()
            }
            drawerLayout.closeDrawers()
            return@OnNavigationItemSelectedListener true
        })

        val eventTypes = ArrayList<EventTypes>()
        eventTypes.add(EventTypes("Roverse","event_data_robotics.json",R.drawable.thumb_roverse))
        eventTypes.add(EventTypes("Brain Teaser","event_data_brain_teaser.json",R.drawable.thumb_brain_teasers))
        eventTypes.add(EventTypes("Gaming","event_data_gaming.json",R.drawable.thumb_games))
        eventTypes.add(EventTypes("Creativity","event_data_creativity.json",R.drawable.thumb_creative))

        viewPager.adapter = EventTypesAdapter(eventTypes,this)

        val sponserList = ArrayList<SponersModel>()

        sponserList.add(SponersModel("Ardent",R.drawable.batch_ardent_logo,  View.VISIBLE))
        sponserList.add(SponersModel("IMS", R.drawable.batch_gateaca, View.VISIBLE))
        sponserList.add(SponersModel("Gate Academy", R.drawable.batch_tga, View.VISIBLE))

        sponserList.add(SponersModel("IAE", R.drawable.batch_tme, View.VISIBLE))
        sponserList.add(SponersModel("Un Engineering", R.drawable.batch_ungineering, View.VISIBLE))
        sponserList.add(SponersModel("MadeEasy", R.drawable.batch_gateaca, View.VISIBLE))

        sponserList.add(SponersModel("Ferrari", R.drawable.batch_ardent_logo, View.VISIBLE))
        sponserList.add(SponersModel("Micros", R.drawable.batch_gateaca, View.INVISIBLE))
        sponserList.add(SponersModel("Micros", R.drawable.batch_gateaca, View.INVISIBLE))

        sponsers_pager.adapter = SponsersAdapter(sponserList,this)
    }
}