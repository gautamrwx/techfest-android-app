package com.gautam0x.techstorm220

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_reg_qr.*
import net.glxn.qrgen.android.QRCode


class RegQrActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_qr)

        // Add Back Button on toolbar
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { finish() }

        // Set Toolbar Title From Extra
        toolbar.title = "Registration Sucessful"


        val subEventName = intent.getStringExtra("subEventName")
        val eventName = intent.getStringExtra("eventName")
        val contactNo = intent.getStringExtra("contactNo")

        ev_name_text.text = eventName
        contact_name_text.text = contactNo

        val qrString = "$subEventName $eventName $contactNo"

        val bitmap = QRCode.from(qrString).withSize(1000, 1000).bitmap()
        qr_image.setImageBitmap(bitmap)
    }
}
