package com.gautam0x.techstorm220

import `in`.codeshuffle.typewriterview.TypeWriterView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.activity_splash.view.*
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ts_quote.setDelay(80)
        ts_quote.animateText("Unleash Your Thoughts");

        val animation1 = AnimationUtils.loadAnimation(this,R.anim.bounce_res)
        ts_new_logo.startAnimation(animation1)

        val animation3 = AnimationUtils.loadAnimation(this,R.anim.aplha_res)
        bottom_layout.startAnimation(animation3)

        val intent = Intent(this,MainActivity::class.java)
        val timer = Timer()
        timer.schedule(timerTask {
            startActivity(intent)
            finish()}, 2500)

    }
}
