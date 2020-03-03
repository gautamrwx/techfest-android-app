package com.gautam0x.techstorm220

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_event_card_swipe.*
import kotlinx.android.synthetic.main.activity_register_user8.*
import kotlinx.android.synthetic.main.activity_register_user8.toolbar

class RegisterUser8Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user8)

        val minMember = intent.getIntExtra("minMember",1)
        val eventName = intent.getStringExtra("eventName")
        val eventCategory = intent.getStringExtra("eventCategory")


        var teamName = "tech team"
        var collegeName = "BPPIMT Kolkata"
        var leaderName = "Dr Fuery"
        var leaderDepartment = "ECE"
        var leaderEmail = "dfuery45@gmail.com"
        var leaderPhone = "9563595522"
        var paymentStatus = "none"
        val gropuMembers = ArrayList<GroupMem>()

        gropuMembers.add(GroupMem("Natasha Romanoff","ECE"))
        gropuMembers.add(GroupMem("Tony Stark","CSE"))
        gropuMembers.add(GroupMem("Peter Parkder","EE"))



        // Add Back Button on toolbar
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { finish() }

        // Set Toolbar Title From Extra
        toolbar.title = eventName
    }
}
