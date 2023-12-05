package com.example.k_vi

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ProgressBar
import android.widget.TextView
import androidx.compose.ui.graphics.Color


class SplashActivity : AppCompatActivity() {
    private val Splash : Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var pb : ProgressBar = findViewById(R.id.progressBar)

        val tv : TextView = findViewById(R.id.textView)

        Handler().postDelayed({
            pb.progress = 3000
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },Splash)

        val animator = ObjectAnimator.ofArgb(
            tv, "textColor",
            0xFF000000.toInt(),
            0xFFB5B5B5.toInt()
        ).apply {
            duration = 500
            interpolator = AccelerateDecelerateInterpolator()
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }

        animator.start()

    }
}