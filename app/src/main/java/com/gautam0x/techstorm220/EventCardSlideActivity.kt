package com.gautam0x.techstorm220

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_event_card_swipe.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.InputStream
import java.lang.Exception

class EventCardSlideActivity : AppCompatActivity() {

    val eventCards = ArrayList<EventCardData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_card_slide)

        // Add Back Button on toolbar
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { finish() }

        // Set Toolbar Title From Extra
        val evenCategory = intent.getStringExtra("eventType")
        toolbar.title = evenCategory

        fillCardWithsEventData()

        // Add events card
        viewPager.adapter = EventCardsAdapter(eventCards,evenCategory,this)
    }

    private fun fillCardWithsEventData() {

        val currentJsonFileName = intent.getStringExtra("jsonFileName")!!

        //read json array
        try {
            // Open Json File
            val inputStream: InputStream = assets.open(currentJsonFileName)
            val rawData = inputStream.bufferedReader().use { it.readText() }

            // Create JSON Array
            val jsonArr = JSONArray(rawData)

            for(i in 0 until jsonArr.length()){
                // Get Plain Text
                val name = jsonArr.getJSONObject(i).getString("event_name")
                val shortDesc = jsonArr.getJSONObject(i).getString("event_short_desc")
                val minMember = jsonArr.getJSONObject(i).getString("event_min_member")
                val maxMember = jsonArr.getJSONObject(i).getString("event_max_member")

                // Find Drawable From Banner Name
                val eventBannerName =  jsonArr.getJSONObject(i).getString("event_banner_drawable")
                val eventBaneerDrawableResId = this.resources.getIdentifier(eventBannerName, "drawable", this.packageName)

                eventCards.add(EventCardData(name,shortDesc,minMember,maxMember,currentJsonFileName,eventBaneerDrawableResId))
            }
        }
        catch (ex: Exception){}
    }
}
