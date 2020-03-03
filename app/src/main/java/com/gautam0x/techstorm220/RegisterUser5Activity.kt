package com.gautam0x.techstorm220

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register_user5.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class RegisterUser5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user5)

        val minMember = intent.getIntExtra("minMember",1)
        val eventName = intent.getStringExtra("eventName")
        val eventCategory = intent.getStringExtra("eventCategory")

        // Add Back Button on toolbar
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { finish() }

        // Set Toolbar Title From Extra
        toolbar.title = eventName

        submit_reg_btn.setOnClickListener {
            val teamName = input_team_name.text.toString()
            val collegeName = input_college_name.text.toString()
            val leaderName = input_mem1_name.text.toString()
            val leaderDepartment = input_mem1_department.text.toString()
            val leaderEmail = input_mem1_email.text.toString()
            val leaderPhone = input_mem1_phone.text.toString()
            val paymentStatus = "none"


            val groupMembers = ArrayList<GroupMem>()

            groupMembers.add(GroupMem(input_mem2_name.text.toString(),input_mem2_department.text.toString()))
            groupMembers.add(GroupMem(input_mem3_name.text.toString(),input_mem3_department.text.toString()))
            groupMembers.add(GroupMem(input_mem4_name.text.toString(),input_mem4_department.text.toString()))
            groupMembers.add(GroupMem(input_mem5_name.text.toString(),input_mem5_department.text.toString()))

            Toast.makeText(applicationContext,"wait", Toast.LENGTH_SHORT).show()

            val ref = FirebaseDatabase.getInstance().getReference("Creativity").child("PassionWithReels")
            val pId = leaderPhone

            val regDetails = RegDetails(teamName,leaderName,collegeName,leaderDepartment,leaderEmail,leaderPhone,groupMembers,paymentStatus, SimpleDateFormat("E MMM dd yyyy HH:mm:ss ", Locale.getDefault()).format(Date())+"GMT+0530 (India Standard Time)")

            ref.child(pId).setValue(regDetails).addOnCompleteListener {
                Toast.makeText(applicationContext, "Sucess", Toast.LENGTH_LONG).show()
            }
        }
    }
}

