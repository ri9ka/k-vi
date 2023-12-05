package com.example.k_vi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBT : Button = findViewById(R.id.button)
        val aboutButton : Button = findViewById(R.id.button7)
        val dopButton : Button = findViewById(R.id.button8)

        startBT.setOnClickListener {
            val intent : Intent = Intent(this@MainActivity, CategoryActivity::class.java)
            startActivity(intent)
        }

        aboutButton.setOnClickListener {
            val intent1 : Intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent1)
        }

        dopButton.setOnClickListener {

            val intent3 : Intent = Intent(this@MainActivity, DopActivity::class.java)
            startActivity(intent3)
        }
    }
}