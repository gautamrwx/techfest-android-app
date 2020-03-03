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


        var teamName = input_team_name.text.toString()
        var collegeName = input_college_name.text.toString()
        var leaderName = input_mem1_name.text.toString()
        var leaderDepartment = input_mem1_department.text.toString()
        var leaderEmail = input_mem1_email.text.toString()
        var leaderPhone = input_mem1_phone.text.toString()
        var paymentStatus = "none"

        val gropuMembers = ArrayList<GroupMem>()

        gropuMembers.add(GroupMem(input_mem2_name.text.toString(),input_mem2_department.text.toString()))
        gropuMembers.add(GroupMem(input_mem3_name.text.toString(),input_mem3_department.text.toString()))
        gropuMembers.add(GroupMem(input_mem4_name.text.toString(),input_mem4_department.text.toString()))
        gropuMembers.add(GroupMem(input_mem5_name.text.toString(),input_mem5_department.text.toString()))
        gropuMembers.add(GroupMem(input_mem6_name.text.toString(),input_mem6_department.text.toString()))
        gropuMembers.add(GroupMem(input_mem7_name.text.toString(),input_mem7_department.text.toString()))
        gropuMembers.add(GroupMem(input_mem8_name.text.toString(),input_mem8_department.text.toString()))



        // Add Back Button on toolbar
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { finish() }

        // Set Toolbar Title From Extra
        toolbar.title = eventName
    }
}
