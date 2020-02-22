package com.gautam0x.techstorm220

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_event_card_swipe.*
import link.fls.swipestack.SwipeStack
import org.json.JSONArray
import java.io.InputStream
import java.lang.Exception

class EventCardSwipeActivity : AppCompatActivity(), SwipeStack.SwipeStackListener {

    var cardList = ArrayList<CardSwipeData>()
    var eventAdapter: CardSwipeAdapter?=null
    var swipeStack: SwipeStack?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_card_swipe)

        // Add Back Button on toolbar
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { finish() }

        // Find Stack In Layout File
        swipeStack = findViewById(R.id.swipe_stack) as SwipeStack

        // Set Adapter
        eventAdapter = CardSwipeAdapter(cardList,this)
        swipeStack!!.adapter = eventAdapter
        swipeStack!!.setListener(this)

        // Set Data Demo
        fillCardWithsEventData()

        // Set Buttons Action
        imgbtn_reload.setOnClickListener { swipeStack!!.resetStack() }
        imgbtn_select.setOnClickListener { swipeStack!!.swipeTopViewToRight()}
        imgbtn_close.setOnClickListener { swipeStack!!.swipeTopViewToLeft()}
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
                val prizeWorth = jsonArr.getJSONObject(i).getString("event_prize_worth")

                // Find Drawable From Banner Name
                val eventBannerName =  jsonArr.getJSONObject(i).getString("event_banner_drawable")
                val eventBaneerDrawableResId = this.resources.getIdentifier(eventBannerName, "drawable", this.packageName)

                cardList.add(CardSwipeData(name,shortDesc,prizeWorth,eventBaneerDrawableResId))
            }
        }
        catch (ex: Exception){}
    }

    override fun onViewSwipedToLeft(position: Int) {
        //Do Nothing
    }
    override fun onViewSwipedToRight(position: Int) {
        // Start EventInformation Intent
        startInformationIntent(position)
    }
    override fun onStackEmpty() {
        swipeStack!!.resetStack()
    }

    fun startInformationIntent(position:Int)
    {
        val currentJsonFileName = intent.getStringExtra("jsonFileName")!!

        val intent = Intent(this,EventFullInformationActivity::class.java)
        intent.putExtra("stackPosition",position)
        intent.putExtra("currentJsonFilename",currentJsonFileName)
        startActivity(intent)
    }
}
