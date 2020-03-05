package com.gautam0x.techstorm220

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.vvalidator.form
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register_user1.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class RegisterUser1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user1)

        val eventName = intent.getStringExtra("eventName")

        // Add Back Button on toolbar
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { finish() }

        // Set Toolbar Title From Extra
        toolbar.title = eventName


        // Validate Data
        form {
            input(R.id.input_mem_email) {
                isNotEmpty()
                //isEmail()
            }
            input(R.id.input_mem_phone) {
                isNotEmpty()
                isNumber()
                length().exactly(10)
            }
            input(R.id.input_college_name) {
                isNotEmpty()
                length().greaterThan(3)
            }
            input(R.id.input_mem_name) {
                isNotEmpty()
                length().greaterThan(3)
            }
            input(R.id.input_mem_department) {
                isNotEmpty()
                length().greaterThan(1)
            }

            submitWith(R.id.submit_reg_btn) { result ->
                performFirebaseSubmission()
            }
        }
    }

    private fun performFirebaseSubmission()
    {
        val minMember = intent.getIntExtra("minMember", 1)
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
        val teamName = ""
        val collegeName = input_college_name.text.toString()
        val leaderName = input_mem_name.text.toString()
        val leaderDepartment = input_mem_department.text.toString()
        val leaderEmail = input_mem_email.text.toString()
        val leaderPhone = input_mem_phone.text.toString()
        val paymentStatus = "none"

        val groupMembers = ArrayList<GroupMem>()

        // Start Action
        val ref = FirebaseDatabase.getInstance().getReference(firebaseEventCategory).child(firebaseEventName)
        val pId = leaderPhone

        val regDetails = RegDetails(teamName,leaderName,collegeName,leaderDepartment,leaderEmail,leaderPhone,groupMembers,paymentStatus, SimpleDateFormat("E MMM dd yyyy HH:mm:ss ", Locale.getDefault()).format(Date())+"GMT+0530 (India Standard Time)")

        ref.child(pId).setValue(regDetails).addOnCompleteListener {
            val intentQr = Intent(this,RegQrActivity::class.java)
            intentQr.putExtra("subEventName",firebaseEventCategory)
            intentQr.putExtra("eventName",firebaseEventName)
            intentQr.putExtra("contactNo",leaderPhone)
            pd.hide()
            startActivity(intentQr)
            finish()
        }
    }
}