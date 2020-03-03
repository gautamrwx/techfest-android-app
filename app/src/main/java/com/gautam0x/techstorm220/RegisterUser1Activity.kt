package com.gautam0x.techstorm220

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register_user1.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class RegisterUser1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user1)

        val minMember = intent.getIntExtra("minMember",1)
        val eventName = intent.getStringExtra("eventName")
        val eventCategory = intent.getStringExtra("eventCategory")

        // Add Back Button on toolbar
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { finish() }

        // Set Toolbar Title From Extra
        toolbar.title = eventName

        submit_reg_btn.setOnClickListener {
            val teamName = ""
            val collegeName = input_college_name.text.toString()
            val leaderName = input_mem_name.text.toString()
            val leaderDepartment = input_mem_department.text.toString()
            val leaderEmail = input_mem_email.text.toString()
            val leaderPhone = input_mem_phone.text.toString()
            val paymentStatus = "none"

            val groupMembers = ArrayList<GroupMem>()

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
