package com.gautam0x.techstorm220

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afollestad.vvalidator.form
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

        // Add Back Button on toolbar
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { finish() }

        // Set Toolbar Title From Extra
        toolbar.title = eventName

        // Validate Data
        form {
            input(R.id.input_mem1_email) {
                isNotEmpty()
                isEmail()
            }
            input(R.id.input_mem1_phone) {
                isNotEmpty()
                isNumber()
                length().exactly(10)
            }
            input(R.id.input_team_name) {
                isNotEmpty()
            }
            input(R.id.input_college_name) {
                isNotEmpty()
                length().greaterThan(3)
            }
            input(R.id.input_mem1_name) {
                isNotEmpty()
                length().greaterThan(3)
            }
            input(R.id.input_mem1_department) {
                isNotEmpty()
                length().greaterThan(1)
            }
            // Start Action
            when (minMember) {
                in 3 downTo 2 -> {
                    input(R.id.input_mem2_name) {
                        isNotEmpty()
                        length().greaterThan(3)
                    }
                    input(R.id.input_mem2_department) {
                        isNotEmpty()
                        length().greaterThan(1)
                    }
                    input(R.id.input_mem3_name) {
                        isNotEmpty()
                        length().greaterThan(3)
                    }
                    input(R.id.input_mem3_department) {
                        isNotEmpty()
                        length().greaterThan(1)
                    }
                }
                in 4 downTo 3 -> {
                    input(R.id.input_mem2_name) {
                        isNotEmpty()
                        length().greaterThan(3)
                    }
                    input(R.id.input_mem2_department) {
                        isNotEmpty()
                        length().greaterThan(1)
                    }
                    input(R.id.input_mem3_name) {
                        isNotEmpty()
                        length().greaterThan(3)
                    }
                    input(R.id.input_mem3_department) {
                        isNotEmpty()
                        length().greaterThan(1)
                    }
                    input(R.id.input_mem4_name) {
                        isNotEmpty()
                        length().greaterThan(3)
                    }
                    input(R.id.input_mem4_department) {
                        isNotEmpty()
                        length().greaterThan(1)
                    }
                }
                in 5 downTo 4 -> {
                    input(R.id.input_mem2_name) {
                        isNotEmpty()
                        length().greaterThan(3)
                    }
                    input(R.id.input_mem2_department) {
                        isNotEmpty()
                        length().greaterThan(1)
                    }
                    input(R.id.input_mem3_name) {
                        isNotEmpty()
                        length().greaterThan(3)
                    }
                    input(R.id.input_mem3_department) {
                        isNotEmpty()
                        length().greaterThan(1)
                    }
                    input(R.id.input_mem4_name) {
                        isNotEmpty()
                        length().greaterThan(3)
                    }
                    input(R.id.input_mem4_department) {
                        isNotEmpty()
                        length().greaterThan(1)
                    }
                    input(R.id.input_mem5_name) {
                        isNotEmpty()
                        length().greaterThan(3)
                    }
                    input(R.id.input_mem5_department) {
                        isNotEmpty()
                        length().greaterThan(1)
                    }
                }
            }
            submitWith(R.id.submit_reg_btn) { result ->
                performFirebaseSubmission()
            }
        }
    }


    private fun performFirebaseSubmission()
    {
        val eventName = intent.getStringExtra("eventName")
        val eventCategory = intent.getStringExtra("eventCategory")

        var firebaseEventName: String = "ERRCHILD"
        var firebaseEventCategory: String = "ERROR"

        when(eventCategory){
            "Roverse" -> {firebaseEventCategory = "Roverse"}
            "Brain Teaser" -> {firebaseEventCategory = "Brain Teasers"}
            "Gaming" -> {firebaseEventCategory = "Games"}
            "Creativity" -> {firebaseEventCategory = "Creative"}
        }

        when(eventName){
            "TECHNOMANIA" -> {firebaseEventName = "TECHNOMANIA"}
            "OMEGATRIX" -> {firebaseEventName = "OMEGATRIX"}
            "APPMANIA" -> {firebaseEventName = "APPMANIA"}
            "FANTA-C" -> {firebaseEventName = "FANTAC"}
            "PASSION-WITH-REELS" -> {firebaseEventName = "PASSIONWITHREELS"}
            "ONLINE-PHOTOGRAPHY" -> {firebaseEventName = "ONLINEPHOTOGRAPHY"}
            "FIFA" -> {firebaseEventName = "FIFA"}
            "COC" -> {firebaseEventName = "COC"}
            "KHET" -> {firebaseEventName = "KHET"}
            "NFS" -> {firebaseEventName = "NFS"}
            "RO-WINGS" -> {firebaseEventName = "ROWINGS"}
            "RO-PICKER" -> {firebaseEventName = "ROPICKER"}
            "RO-NAVIGATOR" -> {firebaseEventName = "RONAVIGATOR"}
            "RO-TERRANCE" -> {firebaseEventName = "ROTERRANCE"}
            "RO-SOCCER" -> {firebaseEventName = "ROSOCCER"}
            "RO-COMBAT" -> {firebaseEventName = "ROCOMBAT"}
            "RO-CARROM" -> {firebaseEventName = "ROCARROM"}
        }

        // Start Progress Circle Lopop
        val pd = ProgressDialog(this)
        pd.setMessage("loading")
        pd.show()

        // Initialize Form Data
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

        // Start Action
        val ref = FirebaseDatabase.getInstance().getReference(firebaseEventCategory).child(firebaseEventName)
        val pId = leaderPhone

        val regDetails = RegDetails(teamName,leaderName,collegeName,leaderDepartment,leaderEmail,leaderPhone,groupMembers,paymentStatus, SimpleDateFormat("E MMM dd yyyy HH:mm:ss ", Locale.getDefault()).format(Date())+"GMT+0530 (India Standard Time)")

        ref.child(pId).setValue(regDetails).addOnCompleteListener {
            val intentQr = Intent(this,RegQrActivity::class.java)
            intentQr.putExtra("subEventName",firebaseEventCategory)
            intentQr.putExtra("eventName",firebaseEventName)
            pd.hide()
            intentQr.putExtra("contactNo",leaderPhone)
            startActivity(intentQr)
            finish()
        }
    }
}

