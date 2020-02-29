package com.gautam0x.techstorm220

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val animation1 = AnimationUtils.loadAnimation(this,R.anim.bounce_res)
        ts_new_logo.startAnimation(animation1)

        val animation2 = AnimationUtils.loadAnimation(this,R.anim.aplha_res)
        ts_quote.startAnimation(animation2)

        val animation3 = AnimationUtils.loadAnimation(this,R.anim.aplha_res)
        bottom_layout.startAnimation(animation3)

        val intent = Intent(this,MainActivity::class.java)
        val timer = Timer()
        timer.schedule(timerTask {
            startActivity(intent)
            finish()}, 1500)
    }
}
