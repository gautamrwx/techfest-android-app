package com.gautam0x.techstorm220

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_event_full_information.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class EventFullInformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_full_information)

        // Add Back Button on toolbar
        tool_bar.setNavigationIcon(R.drawable.ic_arrow_back)
        tool_bar.setNavigationOnClickListener {
            finish()
        }

        // Raad Json file Fill Page Information
        readJsonAndFillData()
    }

    private fun readJsonAndFillData(){

        // Get json array file and position  From last Intent
        val currentJsonFileName = intent.getStringExtra("currentJsonFilename")
        val stackPosition = intent.getIntExtra("stackPosition",0)

        val rulesList = ArrayList<RulesDataModel>()

        try {
            // Open Json File
            val inputStream: InputStream = assets.open(currentJsonFileName)
            val json = inputStream.bufferedReader().use { it.readText() }

            val currentJson = JSONArray(json).getJSONObject(stackPosition)

            // Get Plain Text
            val eventCategory = intent.getStringExtra("eventCategory")
            val drawableBannerName = currentJson.getString("event_banner_drawable")
            val name = currentJson.getString("event_name")
            val longDesc = currentJson.getString("event_long_desc")
            val prizeWorth = currentJson.getString("event_prize_worth")
            val contactName = currentJson.getString("event_contact_name")
            val regFees = currentJson.getString("event_reg_fees")
            val maxMember = currentJson.getInt("event_max_member")
            val minMember = currentJson.getInt("event_min_member")

            desc_text_view.text = longDesc
            prize_worth_text.text = prizeWorth
            event_reg_fees.text = regFees
            event_contact_text.text = contactName

            reg_btn.setOnClickListener {
                when(maxMember){
                    1 -> {
                        val regIntent = Intent(this,RegisterUser1Activity::class.java)
                        regIntent.putExtra("eventCategory",eventCategory)
                        regIntent.putExtra("eventName",name)
                        regIntent.putExtra("minMember",minMember)
                        startActivity(regIntent)
                    }
                    2 -> {
                        val regIntent = Intent(this,RegisterUser2Activity::class.java)
                        regIntent.putExtra("eventCategory",eventCategory)
                        regIntent.putExtra("eventName",name)
                        regIntent.putExtra("minMember",minMember)
                        startActivity(regIntent)
                    }
                    5 -> {
                        val regIntent = Intent(this,RegisterUser5Activity::class.java)
                        regIntent.putExtra("eventCategory",eventCategory)
                        regIntent.putExtra("eventName",name)
                        regIntent.putExtra("minMember",minMember)
                        startActivity(regIntent)
                    }
                    8 -> {
                        val regIntent = Intent(this,RegisterUser8Activity::class.java)
                        regIntent.putExtra("eventCategory",eventCategory)
                        regIntent.putExtra("eventName",name)
                        regIntent.putExtra("minMember",minMember)
                        startActivity(regIntent)
                    }
                }
            }

            // Attach Image Of Event
            val resID = resources.getIdentifier(drawableBannerName, "drawable", packageName)
            event_banner.setImageResource(resID)

            toolBarTitlePropertySet(name)

            // Get Text For RecyclerView
            val rulesListObjArr = currentJson.getJSONArray("event_rule_list")

            var ruleTitle:String
            var ruleDescription:String

            for(i in 0 until rulesListObjArr.length()){

                ruleTitle = rulesListObjArr.getJSONObject(i).getString("rule_title")
                ruleDescription = rulesListObjArr.getJSONObject(i).getString("rule_desc")

                rulesList.add(RulesDataModel(ruleTitle,ruleDescription))
            }

            // Apply to recycler view

            val adapter = RulesAdapter(rulesList,this)

            rules_recycler_view.layoutManager = LinearLayoutManager(applicationContext)
            rules_recycler_view.adapter=adapter
        }
        catch (e: IOException){desc_text_view.text = "reading Prob"}
    }

    // Set Toolbar Layout on Cllapse
    private fun toolBarTitlePropertySet(titleArg:String)
    {
        // Remove Toolbar Title from Non Collapsed Bar
        var isShow = true
        var scrollRange = -1
        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener{ barLayout, verticalOffset->
            if(scrollRange == -1){
                scrollRange = barLayout.totalScrollRange
            }
            if(scrollRange+verticalOffset == 0){
                collapsing_toolbar.title=titleArg
                isShow=true
            }
            else if(isShow)
            {
                collapsing_toolbar.title=""
                isShow=false
            }
        })
    }


}
